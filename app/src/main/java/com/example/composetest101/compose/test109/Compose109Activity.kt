package com.example.composetest101.compose.test109

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
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
import com.example.composetest101.compose.test109.datamodel.Todo
import com.example.composetest101.compose.test109.datamodel.getDefaultToDO
import com.example.composetest101.compose.test109.viewmodel.TodoViewModel

/**
 * https://www.youtube.com/watch?v=PMMY23F0CFg&t=6s
 * https://www.youtube.com/watch?v=kyH01Lg4G1E&t=667s
 * https://developer.android.com/codelabs/jetpack-compose-state#0
 * https://developer.android.com/codelabs/jetpack-compose-layouts#0
 * https://developer.android.com/develop/ui/compose/mental-model
 * https://developer.android.com/codelabs/jetpack-compose-basics#0
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class Compose109Activity : ComponentActivity() {

    val todoViewModel = TodoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxSize()
            ) {
                Scaffold(topBar = {
                    MyTopBar()
                },
                    content = { it ->
                        ContentBody(todoViewModel)
                    }
                )
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyTopBar() {
    TopAppBar(
        title = { Text("TopAppBar") },
        modifier = Modifier.background(MaterialTheme.colorScheme.primary) // Modifier applied properly
    )
}

@Composable
fun ContentBody(todoViewModel: TodoViewModel) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    todoViewModel.getToDoList()
                }, modifier = Modifier.wrapContentHeight()
            ) {
                Text(text = "Button 1")
            }

            Button(
                onClick = {
                    todoViewModel.getToDoList()
                }, modifier = Modifier.wrapContentHeight()
            ) {
                Text(text = "Button 2")
            }
        }


        Column(modifier = Modifier.fillMaxHeight(0.85f)) {
            LazyColumn(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                items(todoViewModel.list) {
                    ToDoCardItem(it)
                }
            }
        }


    }
}

@Composable
private fun ToDoCardItem(todo: Todo = getDefaultToDO()) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(0.9f)
            .wrapContentHeight()
            .padding(4.dp)
            .background(color = Color.White),
        elevation = CardDefaults.cardElevation()
    ) {
        Column {
            Text(text = todo.todo, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun ShowPreviewOfToDoCardItem() {
    ToDoCardItem()
}

