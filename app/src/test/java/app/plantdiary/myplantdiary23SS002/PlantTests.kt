package app.plantdiary.myplantdiary23SS002

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.plantdiary.myplantdiary23SS002.dto.Plant
import app.plantdiary.myplantdiary23SS002.service.PlantService
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class PlantTests {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var plantService : PlantService
    var allPlants : List<Plant>? = ArrayList<Plant>()

    @Test
    fun `Given plant data are available when I search for Redbud then I should receive Cercis canadensis`() = runTest {
        givenPlantServiceIsInitialized()
        whenPlantDataAreReadAndParsed()
        thenPlantCollectionShouldContainCercisCandensis()
    }

    private fun givenPlantServiceIsInitialized() {
        plantService = PlantService()
    }

    private suspend fun whenPlantDataAreReadAndParsed()  {
        allPlants = plantService.fetchPlants();
    }

    private fun thenPlantCollectionShouldContainCercisCandensis() {
        assertNotNull(allPlants)
        assertTrue(allPlants!!.isNotEmpty())
        var containsCercisCanadensis = false
        allPlants!!.forEach {
            if (it.genus.equals("Cercis") && it.species.equals("canadensis")) {
                containsCercisCanadensis = true
            }
        }
        assertTrue(containsCercisCanadensis)
    }

}