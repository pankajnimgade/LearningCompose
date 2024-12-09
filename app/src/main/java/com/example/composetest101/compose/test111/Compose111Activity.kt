package com.example.composetest101.compose.test111


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme

/**
 * https://developer.android.com/codelabs/jetpack-compose-basics#0
 *
 * https://www.youtube.com/watch?v=k3jvNqj4m08
 */

class Compose111Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest101Theme {
                // A Surface container using the background color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }

}


/*********************************************************************************/

@Composable
private fun MyApp(
    modifier: Modifier = Modifier, names: List<String> = listOf("World", "Compose")
) {
    Surface(
        modifier = modifier, color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (item in names) {
                Greeting(item)
            }
        }
    }
}

@Preview(showBackground = true, name = "MyApp Preview", widthDp = 320)
@Composable
fun ShowPreviewOfMyApp() {
    MyApp()
}

/*********************************************************************************/

@Composable
private fun Greeting(text: String = "Android", modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(modifier = modifier.weight(1f)) {
                Text(text = "Hello")
                Text(text = "$text!", modifier = modifier)
            }
            ElevatedButton(onClick = {}) {
                Text(text = "Show more")
            }
        }

    }
}

@Preview(showBackground = true, name = "Greeting Preview")
@Composable
fun ShowPreviewOfGreeting() {
    ComposeTest101Theme {
        Surface(
            modifier = Modifier.wrapContentSize(), color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}

/*********************************************************************************/