package com.example.composetest101.compose.test103

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class GameUiState(
    val currentWord: String = ""
)

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState("currentWord"))
    val uiState = _uiState.asStateFlow()

    fun updateSomeWord() {
        val list = listOf("Jack", "Mark", "Lily", "Alice")
        val word = list[(1..3).random()]
        _uiState.value = GameUiState(word)
    }

}

