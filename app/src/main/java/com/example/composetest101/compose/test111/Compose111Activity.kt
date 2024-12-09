package com.example.composetest101.compose.test111


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme

/**
 * https://developer.android.com/codelabs/jetpack-compose-basics#0
 *
 * https://www.youtube.com/watch?v=k3jvNqj4m08
 *
 * https://developer.android.com/courses/jetpack-compose/course
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


/**MyApp Start*******************************************/
@Composable
private fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen() { shouldShowOnboarding = false }
        } else {
            Greetings()
        }
    }
}

@Preview(showBackground = true, name = "MyApp Preview", widthDp = 320, heightDp = 320)
@Composable
fun ShowPreviewOfMyApp() {
    MyApp()
}
/**MyApp End*******************************************/

/**Greetings Start*******************************************/
@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "Item: $it" }
) {
    Surface(
        modifier = modifier.padding(vertical = 4.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(names) {
                Greeting(it)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ShowPreviewOfGreetings() {
    Greetings()
}
/**Greetings End*******************************************/


/**Greeting Start*******************************************/
@Composable
private fun Greeting(text: String = "Android", modifier: Modifier = Modifier) {
    /**
     * [remember] is used to guard against recomposition, so the state is not reset.
     */
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello")
                Text(
                    text = "$text!",
                    modifier = modifier,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            ElevatedButton(onClick = { expanded = !expanded }) {
                Text(text = if (expanded) "Show less" else "Show more")
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
/**Greeting End*******************************************/

/**OnBoardingScreen Start*******************************************/
@Composable
private fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelabs!")
        Button(
            modifier = modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview(
    showBackground = true, name = "Onboarding Screen Preview", widthDp = 320, heightDp = 320
)
@Composable
fun ShowPreviewOfOnboardingScreen() {
    ComposeTest101Theme {
        OnboardingScreen() {

        }
    }
}
/**OnBoardingScreen End*******************************************/