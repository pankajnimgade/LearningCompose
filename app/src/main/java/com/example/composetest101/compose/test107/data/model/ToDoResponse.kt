package com.example.composetest101.compose.test107.data.model

data class ToDoResponse(
    val limit: Int,
    val skip: Int,
    val todos: List<Todo>,
    val total: Int
)