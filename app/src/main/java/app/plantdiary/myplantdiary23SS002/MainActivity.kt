package app.plantdiary.myplantdiary23SS002

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.plantdiary.myplantdiary23SS002.ui.theme.MyPlantDiaryTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.livedata.observeAsState
import app.plantdiary.myplantdiary23SS002.dto.Plant

class MainActivity : ComponentActivity() {

    // get our ViewModel from Koin
    private val viewModel : MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.fetchPlants()
            // val plants by viewModel.plants.observeAsState(initial = emptyList())
            val plants = ArrayList<Plant>();
            MyPlantDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxWidth()) {
                    Greeting("Android")
                }
                var foo = plants
                var i = 1 + 1
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var plantName by remember{mutableStateOf("")}
    var location by remember{mutableStateOf("")}
    var description by remember{mutableStateOf("")}
    var datePlanted by remember{mutableStateOf("")}
    val context = LocalContext.current
    Column {
        Text(text = "Hello $name!")

        OutlinedTextField(
            value = plantName,
            onValueChange = { plantName = it },
            label = { Text(stringResource(R.string.plantName)) }
        )
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text(stringResource(R.string.location)) }
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(stringResource(R.string.description)) }
        )
        OutlinedTextField(
            value = datePlanted,
            onValueChange = { datePlanted = it },
            label = { Text(stringResource(R.string.datePlanted)) }
        )
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "$plantName $location $description $datePlanted",
                    Toast.LENGTH_LONG
                ).show()
            },

            ) { Text(text = "Save") }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyPlantDiaryTheme {
        Greeting("Android Development")
    }
}