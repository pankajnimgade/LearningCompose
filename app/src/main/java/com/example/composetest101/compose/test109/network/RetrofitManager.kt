package com.example.composetest101.compose.test109.network


import com.example.composetest101.compose.test109.datamodel.ToDoResponse
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
    fun getList(): Call<ToDoResponse>

}