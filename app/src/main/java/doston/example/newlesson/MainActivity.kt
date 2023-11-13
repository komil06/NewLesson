package doston.example.newlesson

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import doston.example.newlesson.ui.theme.NewLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var number by remember { mutableStateOf(0)}
            NewLessonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                 Column(
                     verticalArrangement = Arrangement.spacedBy(
                         space = 10.dp,
                         alignment = Alignment.CenterVertically
                     ),
                     horizontalAlignment = Alignment.CenterHorizontally
                 ) {
                     Text("$number")
                     Row(verticalAlignment = Alignment.CenterVertically){
                         Button(onClick = {number--}, Modifier.padding(10.dp)) {
                             Icon(
                                 Icons.Rounded.KeyboardArrowDown,"Minus Icon",Modifier.size(20.dp)
                             )

                         }
                         Button(onClick = {number++}, Modifier.padding(10.dp)) {
                             Icon(
                                 Icons.Rounded.KeyboardArrowUp,"Plus Icon",Modifier.size(20.dp)
                             )

                         }
                         if (number>0 && number!=0){
                             Icon(
                                 modifier = Modifier.size(50.dp),
                                 painter = painterResource(id = R.drawable.baseline_thumb_up_24),
                                 contentDescription = null
                             )
                         }
                         if (number<0 && number!=0){
                             Icon(
                                 modifier = Modifier.size(50.dp),
                                 painter = painterResource(id = R.drawable.baseline_thumb_down_24),
                                 contentDescription = null
                             )
                         }

                     }
                     Button(onClick = {number = 0}) {
                         Icon(
                             Icons.Rounded.Refresh,"Reset",Modifier.size(20.dp)
                         )
                     }
                 }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewLessonTheme {
        Greeting("Android")
    }
}
