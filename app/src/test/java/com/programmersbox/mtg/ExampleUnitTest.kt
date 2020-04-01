package com.programmersbox.mtg

import com.programmersbox.gsonutils.getApi
import com.programmersbox.gsonutils.getJsonApi
import com.programmersbox.loggingutils.Loged
import com.programmersbox.loggingutils.f
import com.programmersbox.mtg.MtGCards.Base
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
        val s = getJsonApi<Base>("https://api.scryfall.com/cards?page=1")!!.data!!
        Loged.f(s)
    }
}