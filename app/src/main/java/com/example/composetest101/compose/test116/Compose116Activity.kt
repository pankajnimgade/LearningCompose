package com.example.composetest101.compose.test116

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

/**
 * https://developer.android.com/codelabs/jetpack-compose-state#0
 * https://www.youtube.com/watch?v=PMMY23F0CFg
 */
class Compose116Activity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessScreen()
        }
    }

}