package com.example.composetest101.compose.test105

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme

class Compose105Activity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest101Theme {
                ComposeTest105()
            }
        }
    }
}

@Composable
private fun ComposeTest105() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp)
    ) {
       LazyColumn {

           item {
               Text(text = "First Item")
           }

           items(5){
               Text(text = " Item :  $it")
           }

           item {
               Text(text = "Last Item")
           }
       }

    }
}


@Preview
@Composable
private fun ComposeTest105Preview() {
    ComposeTest105()
}