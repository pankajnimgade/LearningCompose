package com.example.composetest101.compose.test110

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

/**
 * https://developer.android.com/develop/ui/compose/mental-model
 */
class Compose110Activity : ComponentActivity() {

    private val TAG = "Compose110Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxSize()
            ) {
                NamePicker(
                    "Mike",
                    mutableListOf<String>("Mike","Jhon","Rob","laura")
                ) {
                    Log.d(TAG, "onCreate: $it")
                }
            }
        }
    }
}


@Composable
private fun NamePicker(
    header: String,
    names: List<String>,
    onNameClicked: (String) -> Unit
) {
    Column {
        // this will re-compose when header changes but not when name changes
        Text(text = header, style = MaterialTheme.typography.bodyLarge)
        HorizontalDivider()

        LazyColumn {
            items(names) {
                NamePickerItem(it, onNameClicked)
            }
        }
    }
}


/**
 * Display a single name the user can click
 */
@Composable
private fun NamePickerItem(name: String, onClicked: (String) -> Unit) {
    Text(text = name, Modifier.clickable { onClicked(name) })
}


@Composable
private fun SharedPrefsToggle(
    text: String,
    value: Boolean,
    onValueChanged: (Boolean) -> Unit
) {
    Row(modifier = Modifier.background(color = Color.White)) {
        Text(text = text)
        Checkbox(checked = value, onCheckedChange = onValueChanged)
    }
}

@Preview
@Composable
fun ShowPreviewOfSharedPrefsToggle() {
    SharedPrefsToggle("Hello me", value = false) {

    }
}


@Composable
private fun Greetings() {
    Text(
        text = "Hello me, I hope you are well, you will be okay",
        modifier = Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun ShowPreviewOfGreetings() {
    Greetings()
}
