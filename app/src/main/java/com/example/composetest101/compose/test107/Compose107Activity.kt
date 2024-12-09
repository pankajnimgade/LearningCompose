@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composetest101.compose.test107


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme
import com.example.composetest101.compose.test107.data.model.Todo
import com.example.composetest101.compose.test107.viewmodel.ToDoViewModel

/**
 * https://paulallies.medium.com/jetpack-compose-api-data-to-list-view-35cb5ea66a95
 *
 */
class Compose107Activity : ComponentActivity() {

    val toDoViewModel: ToDoViewModel = ToDoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest101Theme {
                ToDoScreen(toDoViewModel)
            }
        }

    }


}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun ToDoScreen(toDoViewModel: ToDoViewModel) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Scaffold(topBar = {
            MyTopBar()
        },
            content = { it ->
                ContentBody(toDoViewModel)
            }
        )
    }
}

@Composable
fun ContentBody(toDoViewModel: ToDoViewModel) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { toDoViewModel.getListOfToDo() }) {
                Text("Button 1")
            }
            Button(onClick = {}) {
                Text("Button 2")
            }
            Button(onClick = {}) {
                Text("Button 3")
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(toDoViewModel.currentList) { toDo ->
                ToDoCard(toDo)
            }
        }
    }
}

@Composable
fun ToDoCard(toDo: Todo) {

    Card(modifier = Modifier.padding(4.dp), elevation = CardDefaults.cardElevation()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.White)
                .padding(4.dp)
        ) {
            Text(text = toDo.todo)
            Text(text = "${toDo.userId}")
            Text(text = " ${toDo.completed}")
        }
    }
}

@Preview
@Composable
fun ShowPreviewOfToDoCard() {
    ToDoCard(Todo(completed = true, id = 1, todo = "Todo", userId = 12))
}


@Preview
@Composable
fun ShowPreviewOf() {
    ContentBody(ToDoViewModel())
}


@Composable
private fun MyTopBar() {
    TopAppBar(
        title = { Text("To do List") },
        modifier = Modifier.background(MaterialTheme.colorScheme.primary) // Modifier applied properly
    )
}

@Preview
@Composable
private fun ToDoScreenPreview() {
    ToDoScreen(ToDoViewModel())
}