package com.example.composetest101.compose.test114.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composetest101.compose.test114.datamodels.Quote
import com.example.composetest101.compose.test114.datamodels.QuoteResponse
import com.example.composetest101.compose.test114.retrofit.manager.RetrofitAPI
import com.example.composetest101.compose.test114.retrofit.manager.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Compose114ViewModel : ViewModel() {

    var TAG: String

    init {
        TAG = this.javaClass.simpleName
    }

    var list = mutableStateListOf<Quote>()
        private set

    fun getQuotes(text: String) {

        val api = getRetrofit().create(RetrofitAPI::class.java)
        api.getQuotes().enqueue(object : Callback<QuoteResponse> {
            override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                response.body()?.let {

                    Log.d(TAG, "success: $it")
                    list.clear()
                    list.addAll(it.quotes)
                }
            }

            override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                // Good luck
                Log.d(TAG, "Good luck :(  ${t}")

            }

        })

    }
}