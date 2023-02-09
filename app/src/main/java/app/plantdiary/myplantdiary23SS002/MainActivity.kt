package app.plantdiary.myplantdiary23SS002

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.plantdiary.myplantdiary23SS002.ui.theme.MyPlantDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPlantDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var plantName by remember{mutableStateOf("")}
    Text(text = "Hello $name!")
    OutlinedTextField(
        value=plantName,
        onValueChange = {plantName = it},
        label = {Text(stringResource(R.string.plantName))}
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyPlantDiaryTheme {
        Greeting("Android Development")
    }
}