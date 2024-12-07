package com.example.composetest101.compose.test109.datamodel

data class Todo(
    val completed: Boolean,
    val id: Int,
    val todo: String,
    val userId: Int
)

fun getDefaultToDO() = Todo(completed = true, id = 1, todo = "Example todo item", userId = 1)