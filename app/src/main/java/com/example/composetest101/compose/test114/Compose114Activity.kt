package com.example.composetest101.compose.test114


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test114.viewmodels.Compose114ViewModel

class Compose114Activity : ComponentActivity() {

    val viewModel by viewModels<Compose114ViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getQuotes("")
        setContent {
            Scaffold(
                topBar = {
                    MyTopBar()
                }
            ) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {

                    Text(text = "Something to be")
                    MySpace()
                    LazyColumn(
                        modifier = Modifier.padding(8.dp),
                        contentPadding = PaddingValues(
                            top = 8.dp,
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                    ) {

                        items(viewModel.list.toList()) {
                            Column(
                                modifier = Modifier.padding(
                                    PaddingValues(
                                        top = 8.dp,
                                        start = 8.dp,
                                        end = 8.dp,
                                        bottom = 8.dp
                                    )
                                )
                            ) {
                                Text(text = "Quote: ${it.quote}")
                                MySpace()
                                Text(text = "Author: ${it.author}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyTopBar() {
    TopAppBar(
        title = { Text("MyTopAppBar", color = Color.White) },
//        modifier = Modifier.background(MaterialTheme.colorScheme.primary)
        colors = TopAppBarDefaults.topAppBarColors().copy(MaterialTheme.colorScheme.primary)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfMyTopBar() {
    MyTopBar()
}

@Composable
fun MySpace(modifier: Modifier = Modifier) {
    Spacer(
        modifier = Modifier
            .height(4.dp)
            .width(4.dp)
            .wrapContentHeight()
            .wrapContentWidth()
    )
}





