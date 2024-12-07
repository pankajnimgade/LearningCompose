package com.example.composetest101.compose.test109.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composetest101.compose.test109.datamodel.ToDoResponse
import com.example.composetest101.compose.test109.datamodel.Todo
import com.example.composetest101.compose.test109.network.RetrofitAPI
import com.example.composetest101.compose.test109.network.getRetrofit
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class TodoViewModel : ViewModel() {

    val TAG = "TodoViewModel"

    val _todoList = mutableStateListOf<Todo>()
    val list: List<Todo> = _todoList


    fun getToDoList(): List<Todo> {
        val retrofitAPI = getRetrofit().create(RetrofitAPI::class.java)
        retrofitAPI.getList().enqueue(object : Callback<ToDoResponse> {
                    override fun onResponse(call: Call<ToDoResponse>, response: Response<ToDoResponse>) {
                        response.body()?.let {
                            _todoList.clear()
                            _todoList.addAll(it.todos)
                            Log.d(TAG, "success: $it")
                        }
                    }

                    override fun onFailure(call: Call<ToDoResponse>, t: Throwable) {
                        // Good luck
                        Log.d(TAG, "Good luck :(  ${t}")

                    }

                })
        return list
    }

}