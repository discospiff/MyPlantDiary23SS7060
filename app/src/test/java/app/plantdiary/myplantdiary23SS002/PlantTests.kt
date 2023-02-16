package app.plantdiary.myplantdiary23SS002

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class PlantTests {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var plantService : PlantService

    @Test
    fun `Given plant data are available when I search for Redbud then I should receive Cercis canadensis` {
        givenPlantServiceIsInitialized()
        whenPlantDataAreReadAndParsed()
        thenPlantCollectionShouldContainCercisCandensis()
    }

    private fun givenPlantServiceIsInitialized() {
        plantService = PlantService()
    }

    private fun whenPlantDataAreReadAndParsed() {
        TODO("Not yet implemented")
    }

    private fun thenPlantCollectionShouldContainCercisCandensis() {
        TODO("Not yet implemented")
    }

}