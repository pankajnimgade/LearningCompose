package com.example.composetest101.compose.test116

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = { newValue ->
            checkedState = newValue
            onCheckedChange(checkedState)
        },
        onClose = onClose, // we will implement this later!
        modifier = modifier,
    )
}

@Composable
private fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName, modifier = modifier
                .weight(1f)
                .padding(16.dp)
        )
        Checkbox(
            checked = checked, onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }

    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfWellnessTaskItem() {
    Surface(modifier = Modifier.padding(8.dp)) {
        WellnessTaskItem(taskName = "This is a task",
            onClose = {},
            checked = false,
            onCheckedChange = {})
    }
}