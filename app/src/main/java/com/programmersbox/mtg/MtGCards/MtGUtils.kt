package com.programmersbox.mtg.MtGCards

import com.programmersbox.gsonutils.getJsonApi
import com.programmersbox.loggingutils.Loged
import com.programmersbox.loggingutils.f

@DslMarker
annotation class MtGMarker

class MtGApi {

    private val url = "https://api.scryfall.com/cards"

    @MtGMarker
    interface MtgInterface {
        fun build(): String
    }

    private var page: Page = Page()

    @MtGMarker
    fun page(block: Page.() -> Unit) = page.apply(block).let { Unit }

    private var useSearch = false
    private var search: Search = Search()

    @MtGMarker
    fun search(block: Search.() -> Unit) = search.apply(block).let { useSearch = true }

    private fun build() = getJsonApi<Base>("$url${if (useSearch) "${search.build()}&${page.build()}" else "?${page.build()}"}")?.data

    companion object {
        @MtGMarker
        fun get(block: MtGApi.() -> Unit) = MtGApi().apply(block).build()

        @MtGMarker
        operator fun invoke(block: MtGApi.() -> Unit) = get(block)
    }

}

class Page : MtGApi.MtgInterface {
    var pageNumber: Int = 1
    override fun build(): String = "page=$pageNumber"
}

class Search : MtGApi.MtgInterface {

    enum class SortTypes {
        NAME, SET, RELEASED, RARITY, COLOR, USD, TIX, EUR, CMC, POWER, TOUGHNESS, EDHREC, ARTIST
    }

    private val searchParam = "/search"
    var searchText = ""
    var sort: SortTypes = SortTypes.NAME
    override fun build(): String = "$searchParam?order=${sort.name}&q=$searchText"
}