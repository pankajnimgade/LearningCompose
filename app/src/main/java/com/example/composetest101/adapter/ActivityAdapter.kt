package com.example.composetest101.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.composetest101.R

data class ActivityItem(val name: String, val clazz: Class<out Activity>)

class ActivityAdapter(val list: List<ActivityItem>, val listener: ActivityAdapter.Listener) :
    RecyclerView.Adapter<ActivityAdapter.ItemViewHolder>() {

    interface Listener {
        fun onClick(activityItem: ActivityItem)
    }

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val subTitle: TextView = view.findViewById(R.id.tv_sub_title)

        fun bind(activityItem: ActivityItem, listener: Listener) {
            title.text = activityItem.name ?: ""
            subTitle.text = activityItem.clazz.name ?: ""
            view.setOnClickListener{
                listener.onClick(activityItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }
}