package com.example.filterapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class FilterViewHolder(v: View):RecyclerView.ViewHolder(v) {

    val filtername: TextView =v.findViewById(R.id.filtername)
    val filterimage: ImageView =v.findViewById(R.id.filter_image)
}