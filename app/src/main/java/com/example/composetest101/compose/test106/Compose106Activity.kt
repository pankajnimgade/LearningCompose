package com.example.composetest101.compose.test106

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.R
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme


/**
 * https://medium.com/@mal7othify/lists-using-lazycolumn-in-jetpack-compose-c70c39805fbc
 */
class Compose106Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest101Theme {
                Compose106Test()
            }
        }
    }
}

@Composable
private fun Compose106Test() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(8.dp)
        ) {

            AllPlants(platList = getList())
        }
    }
}

fun getList(): List<Plant> {
    return listOf(
        Plant(name = "name", description = "description", imageRes = R.drawable.kermit_snow),
        Plant(name = "name", description = "description", imageRes = R.drawable.kermit_snow),
        Plant(name = "name", description = "description", imageRes = R.drawable.kermit_snow),
        Plant(name = "name", description = "description", imageRes = R.drawable.kermit_snow),
        Plant(name = "name", description = "description", imageRes = R.drawable.kermit_snow),
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllPlants(platList: List<Plant>) {

    LazyColumn(
        modifier = Modifier
            .statusBarsPadding()
            .padding(8.dp)
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Plants in cosmetics", style = MaterialTheme.typography.headlineMedium)
            }
        }

        items(items = platList) {
            PlantCard(name = it.name, description = it.description, image =it.imageRes)
        }

    }
}

@Composable
fun PlantCard(name: String, description: String, image: Int) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .padding(8.dp),
            contentScale = ContentScale.Fit,
        )
    }
}

@Preview
@Composable
private fun Compose106TestPreview() {
    Compose106Test()
}