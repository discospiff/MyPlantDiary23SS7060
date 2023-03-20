package app.plantdiary.myplantdiary23SS002.service

import app.plantdiary.myplantdiary23SS002.RetrofitClientInstance
import app.plantdiary.myplantdiary23SS002.dao.IPlantDAO
import app.plantdiary.myplantdiary23SS002.dto.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

interface IPlantService {
    suspend fun fetchPlants() : List<Plant>?
}

class PlantService : IPlantService {
    override suspend fun fetchPlants(): List<Plant>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(IPlantDAO::class.java)
            val plants = async {service?.getAllPlants()}
            var result = plants.await()?.awaitResponse()?.body()
            return@withContext result

        }
    }

}
