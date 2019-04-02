package com.example.filterapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class FilterAdapter(val context: Context,
                    var data:ArrayList<filter>,
                    val applyfilter:(Int)->Unit): RecyclerView.Adapter<FilterViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FilterViewHolder {
        val itemView= LayoutInflater.from(p0.context).inflate(R.layout.filter_item,p0,false)
        return FilterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: FilterViewHolder, p1: Int) {
       // p0.filtername.text= data[p1].name
        p0.filterimage.setImageBitmap(data[p1].image)
        p0.itemView.setOnClickListener{
            applyfilter(p1)
        }
    }
}