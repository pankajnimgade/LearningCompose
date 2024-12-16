package com.example.composetest101.compose.test114.retrofit.manager

import com.example.composetest101.compose.test114.datamodels.QuoteResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * https://dummyjson.com/quotes
 */
fun getRetrofit(): Retrofit {
    val BASE_URL = "https://dummyjson.com/"
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


interface RetrofitAPI {

    @GET("quotes")
    fun getQuotes(): Call<QuoteResponse>
}

