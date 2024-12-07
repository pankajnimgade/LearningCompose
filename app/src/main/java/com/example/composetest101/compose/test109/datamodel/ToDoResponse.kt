package com.example.composetest101.compose.test109.datamodel

data class ToDoResponse(
    val limit: Int,
    val skip: Int,
    val todos: List<Todo>,
    val total: Int
)