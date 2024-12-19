package com.example.composetest101.compose.test115

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val TAG = "WaterCounter"

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count: MutableIntState = remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        if (count.intValue > 0) {

            var showTask by remember { mutableStateOf(true) }

            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minutes walk today?",
                    onClose = { showTask = false }
                )
            }

            Text(
                text = "You've had ${count.intValue} glasses",
                modifier = modifier
                    .padding(all = 16.dp)
            )
        }
        Row(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = {
                    count.intValue++

                    Log.d(TAG, "WaterCounter: ${count.intValue}")
                },
                modifier = modifier
                    .wrapContentWidth(),
                enabled = count.intValue < 10
            ) {
                Text(text = "Add one", modifier = modifier.wrapContentSize())
            }
            OutlinedButton(
                onClick = {
                    count.intValue = 0
                    Log.d(TAG, "WaterCounter: clear water count: ${count.intValue}")
                },
                modifier = modifier
                    .wrapContentWidth(),
                enabled = count.intValue < 10
            ) {
                Text(text = "Clear water count", modifier = modifier.wrapContentSize())
            }
        }

    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOf() {
    Surface(modifier = Modifier.padding(all = 8.dp)) {
        WaterCounter()
    }
}