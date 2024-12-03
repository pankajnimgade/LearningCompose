package com.example.composetest101.compose.test108

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test108.viewmodel.UserStateViewModel
import kotlinx.coroutines.launch

/**
 * https://paulallies.medium.com/login-logout-flow-android-jetpack-compose-and-compositionlocal-d2d1784c0d15
 */


class Compose108Activity : ComponentActivity() {

    private val UserState: UserStateViewModel = UserStateViewModel()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                        ContentBody(UserState)
                    }
                )
            }
        }

    }
}

@Composable
fun ContentBody(UserState: UserStateViewModel) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(text = "Something to be - Rob Thomas")
        ApplicationSwitcher(UserState)
    }
}

@Composable
fun ApplicationSwitcher(UserState: UserStateViewModel) {
    val vm = UserState
    if (vm.isLoggedIn) {
        HomeScreen(UserState)
    } else {
        LoginScreen(UserState)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun HomeScreen(UserState: UserStateViewModel) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Scaffold(topBar = {
            MyTopBar()
        },
            content = { it ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Home screen", style = MaterialTheme.typography.displayMedium)
                    Button(onClick = {
                        coroutineScope.launch {
                            UserState.signOff()
                        }
                    }) {
                        Text(
                            text = "Log-off",
                            modifier = Modifier.wrapContentWidth(),
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        )
    }
}

@Composable
private fun LoginScreen(UserState: UserStateViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val vm = UserState

    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (vm.isBusy) {
            CircularProgressIndicator()
        } else {
            Text("Login Screen")
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
            )
            TextField(value = email, onValueChange = {
                email = it
            })
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
            )
            TextField(value = password, onValueChange = {
                password = it
            })

            Button(onClick = {
                coroutineScope.launch {
                    vm.signIn(email, password)
                }
            }) {
                Text(text = "Login", color = Color.White)
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



