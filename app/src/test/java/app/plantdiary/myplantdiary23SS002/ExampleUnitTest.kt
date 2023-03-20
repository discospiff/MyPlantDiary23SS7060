package app.plantdiary.myplantdiary23SS002

import app.plantdiary.myplantdiary23SS002.dto.Plant
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun threePlusThreee_EqualsSix() {
        assertEquals(6, 3 + 3)
    }

    @Test
    fun threePlusFour_EqualsSeven() {
        assertEquals(7, 3+4)
    }

    @Test
    fun fourPlusFour_EqualsEight() {
        assertEquals(8, 4+4)
    }

    @Test
    fun fivePlusFour_EqualsNine() {
        assertEquals(9, 5+4)
    }

    @Test
    fun confirmEasternRedbud_outputsEasternRedbud() {
        val plant : Plant = Plant("Cercis", "canadensis", "Eastern Redbud")
        assertEquals("Eastern Redbud", plant.toString())
    }

}