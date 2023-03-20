package app.plantdiary.myplantdiary23SS002

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import app.plantdiary.myplantdiary23SS002.dto.Plant
import app.plantdiary.myplantdiary23SS002.service.PlantService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class PlantUnitTests {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var mvm : MainViewModel

    @MockK
    lateinit var mockPlantService : PlantService

    private val mainThreadSurrogate = newSingleThreadContext("Main Thread")

    @Before
    fun initMocksAndMainThread() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `given a view model with live data when populated with plants then results show Oak`() {
        givenViewModelIsInitializedWithMockData()
        whenPlantServiceFetchPlantsIsInvoked()
        thenResultsShouldContainOak()
    }

    private fun givenViewModelIsInitializedWithMockData() {
        val plants = ArrayList<Plant>()
        val whiteOak = Plant("Quercus", "alba", "White Oak")
        plants.add(whiteOak)
        val englishOak = Plant("Quercus", "robur", "English Oak")
        plants.add(englishOak)
        coEvery{mockPlantService.fetchPlants()} returns plants

        mvm = MainViewModel(plantService = mockPlantService)
    }

    private fun whenPlantServiceFetchPlantsIsInvoked() {
        mvm.fetchPlants()
    }

    private fun thenResultsShouldContainOak() {
        var allPlants : List<Plant>? = ArrayList<Plant>()
        val latch = CountDownLatch(1)
        val observer = object : Observer<List<Plant>> {
            override fun onChanged(receivedPlants : List<Plant>?) {
                allPlants = receivedPlants
                latch.countDown()
                mvm.plants.removeObserver(this)
            }

        }

        mvm.plants.observeForever(observer)
        latch.await(10, TimeUnit.SECONDS)
        assertNotNull(allPlants)
        assertTrue(allPlants!!.isNotEmpty())
        var containsTwoOaks = false
        allPlants!!.forEach {
            if (it.genus.equals("Quercus") && it.species.equals("alba")) {
                containsTwoOaks = true
            }
        }
        assertTrue(containsTwoOaks)
    }

}