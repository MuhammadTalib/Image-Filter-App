package com.example.filterapp

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.ArrayList

/**
 * Created by Hussein on 24/03/2017.
 */

class EffectsList : ListActivity() {

    var effects = ArrayList<String>()
    lateinit var path: String
    lateinit var effect_chosen: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val i = intent
        path = i.getStringExtra("image thumbnail path")


        effects.add("tint")
        effects.add("violet")
        effects.add("Green effect")
        effects.add("Amaro")
        effects.add("RedEye")
        effects.add("greyscale")
        effects.add("winter")
        effects.add("Willow")
        effects.add("Warm")
        effects.add("Hudson")

        listAdapter = ArrayAdapter(this, R.layout.activity_effects_list, effects)

        val listView = listView
        listView.isTextFilterEnabled = true

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            effect_chosen = effects[position]

            applyEffects()
        }
    }

    internal fun applyEffects() {
        val i = Intent(this@EffectsList, AddedEffects::class.java)
        i.putExtra("path", path)
        i.putExtra("effect", effect_chosen)
        startActivity(i)
    }
}
