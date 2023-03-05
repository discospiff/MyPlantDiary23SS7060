package app.plantdiary.myplantdiary23SS002.dao

import retrofit2.Call
import retrofit2.http.GET

interface IPlantDAO {

    @GET("")
    fun getAllPlants() : Call<ArrayList<Plant>>
}