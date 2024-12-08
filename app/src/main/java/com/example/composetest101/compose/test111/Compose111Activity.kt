package com.example.composetest101.compose.test111

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

}

@Preview
@Composable
fun ShowPreviewOfGreeting() {
    ComposeTest101Theme {
        Greeting()
    }
}


@Composable
private fun Greeting(text: String = "Android", modifier: Modifier = Modifier) {
    Text(
        text = "Hello $text",
        modifier = modifier
    )
}