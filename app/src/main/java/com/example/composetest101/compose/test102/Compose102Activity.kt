package com.example.composetest101.compose.test102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.R
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme

class Compose102Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTest101Theme {
                GameStatus()
            }
        }
    }

}

@Composable
private fun GameStatus() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card() {
            Text(
                text = stringResource(R.string.hello_me),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
}

@Preview
@Composable
private fun GameStatusPreview() {
    GameStatus()
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ComposeTest101Theme {
        Greeting("Android")
    }
}