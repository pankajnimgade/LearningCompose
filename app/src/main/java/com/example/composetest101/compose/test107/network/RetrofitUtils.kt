package com.example.composetest101.compose.test107.network

import com.example.composetest101.compose.test107.data.model.ToDoResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * https://dummyjson.com/todos
 */

fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

interface RetrofitAPI {

    @GET("todos")
    fun getToDoList(): Call<ToDoResponse>
}