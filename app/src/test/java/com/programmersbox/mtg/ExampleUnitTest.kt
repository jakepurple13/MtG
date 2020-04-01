package com.programmersbox.mtg

import com.programmersbox.gsonutils.getApi
import com.programmersbox.gsonutils.getJsonApi
import com.programmersbox.loggingutils.Loged
import com.programmersbox.loggingutils.f
import com.programmersbox.mtg.MtGCards.Base
import com.programmersbox.mtg.MtGCards.MtGApi
import com.programmersbox.mtg.MtGCards.Search
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Before
    fun setup() {
        Loged.FILTER_BY_PACKAGE_NAME = "programmersbox"
        Loged.UNIT_TESTING = true
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun gettingTest() {
        val s = MtGApi { search { searchText = "Who" } }
        Loged.f(s)
    }

    @Test
    fun gettingTest2() {
        val s = MtGApi {
            page { pageNumber = 1 }
            search {
                sort = Search.SortTypes.CMC
                searchText = "Who"
            }
        }
        Loged.f(s)
    }
}