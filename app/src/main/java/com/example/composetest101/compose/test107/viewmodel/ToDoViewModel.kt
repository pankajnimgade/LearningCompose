package com.example.composetest101.compose.test107.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composetest101.compose.test107.data.model.ToDoResponse
import com.example.composetest101.compose.test107.data.model.Todo
import com.example.composetest101.compose.test107.network.RetrofitAPI
import com.example.composetest101.compose.test107.network.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ToDoViewModel : ViewModel() {

    private val TAG = "ToDoViewModel"

    private val _list = mutableStateListOf<Todo>()
    val currentList: List<Todo> = _list

    fun getListOfToDo(): List<Todo> {

        val api = getRetrofit().create(RetrofitAPI::class.java)
        api.getToDoList().enqueue(object : Callback<ToDoResponse> {
            override fun onResponse(call: Call<ToDoResponse>, response: Response<ToDoResponse>) {
                response.body()?.let { newList ->
                    _list.clear()
                    _list.addAll(newList.todos)
                    Log.d(TAG, "success: $newList")
                }
            }

            override fun onFailure(call: Call<ToDoResponse>, t: Throwable) {
                // Good luck
                Log.d(TAG, "Good luck :(  ${t}")

            }

        })

        return currentList
    }

}