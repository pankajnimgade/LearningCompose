package com.example.composetest101.compose.test104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme

class Compose104Activity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTest101Theme {
                ComposeTest104()
            }
        }
    }
}

@Composable
private fun ComposeTest104() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Text(text = "Hello :) ")
        MessageList(list = listOf("Rob", "Thomas", "Jack"))
    }
}


@Preview
@Composable
private fun ComposeTest104Preview() {
    ComposeTest104()
}

@Composable
private fun MessageList(list: List<String> = emptyList()) {

    Column {
        list.forEach {
            MessageRow(it)
        }
    }

}

@Composable
private fun MessageRow(text: String = "Something to be") {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}