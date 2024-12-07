package com.example.composetest101

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.composetest101.adapter.ActivityAdapter
import com.example.composetest101.adapter.ActivityItem
import com.example.composetest101.compose.test101.Compose101Activity
import com.example.composetest101.compose.test102.Compose102Activity
import com.example.composetest101.compose.test103.Compose103Activity
import com.example.composetest101.compose.test104.Compose104Activity
import com.example.composetest101.compose.test105.Compose105Activity
import com.example.composetest101.compose.test106.Compose106Activity
import com.example.composetest101.compose.test107.Compose107Activity
import com.example.composetest101.compose.test108.Compose108Activity
import com.example.composetest101.compose.test109.Compose109Activity
import com.example.composetest101.compose.test110.Compose110Activity

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
        list.add(ActivityItem("Compose110Activity", Compose110Activity::class.java))
        list.add(ActivityItem("Compose109Activity", Compose109Activity::class.java))
        list.add(ActivityItem("Compose108Activity", Compose108Activity::class.java))
        list.add(ActivityItem("Compose107Activity", Compose107Activity::class.java))
        list.add(ActivityItem("Compose106Activity", Compose106Activity::class.java))
        list.add(ActivityItem("Compose105Activity", Compose105Activity::class.java))
        list.add(ActivityItem("Compose104Activity", Compose104Activity::class.java))
        list.add(ActivityItem("Compose103Activity", Compose103Activity::class.java))
        list.add(ActivityItem("Compose102Activity", Compose102Activity::class.java))
        list.add(ActivityItem("Compose101Activity", Compose101Activity::class.java))
        return list
    }

    override fun onClick(activityItem: ActivityItem) {
        val intent = Intent(this@MainActivity, activityItem.clazz)
        startActivity(intent)
    }
}