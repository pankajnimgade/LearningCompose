package com.example.composetest101

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.composetest101.adapter.ActivityAdapter
import com.example.composetest101.adapter.ActivityItem
import com.example.composetest101.compose.test101.Compose101Activity

class MainActivity : AppCompatActivity(), ActivityAdapter.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI() {
        val list = getListOfActivities()
        val adapter = ActivityAdapter(list, this@MainActivity)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun getListOfActivities(): List<ActivityItem> {
        val list: MutableList<ActivityItem> = mutableListOf()
        list.add(ActivityItem("Compose101Activity", Compose101Activity::class.java))
        return list
    }

    override fun onClick(activityItem: ActivityItem) {
        val intent = Intent(this@MainActivity, activityItem.clazz)
        startActivity(intent)
    }


}