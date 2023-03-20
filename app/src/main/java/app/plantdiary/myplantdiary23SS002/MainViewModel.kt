package app.plantdiary.myplantdiary23SS002

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.plantdiary.myplantdiary23SS002.service.IPlantService
import app.plantdiary.myplantdiary23SS002.service.PlantService
import androidx.lifecycle.viewModelScope
import app.plantdiary.myplantdiary23SS002.dto.Plant
import kotlinx.coroutines.launch

class MainViewModel(var plantService : IPlantService = PlantService()) : ViewModel() {

    var plants : MutableLiveData<List<Plant>> = MutableLiveData<List<Plant>>()

    fun fetchPlants() {
        viewModelScope.launch {
            var innerPlants = plantService.fetchPlants()
            plants.postValue(innerPlants)
        }
    }

}
