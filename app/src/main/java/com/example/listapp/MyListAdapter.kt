package com.example.listapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter (private val context: Activity, private val first_titles: Array<String>, private val first_icons: Array<Int>):ArrayAdapter<String>(context, R.layout.activity_listview, first_titles) {

    override fun getView(position: Int, View: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.activity_listview, null, true)

        val firstTitleText = rowView.findViewById<TextView>(R.id.firstTitleText)
        val firstImageView = rowView.findViewById<ImageView>(R.id.firstImageView)

        firstTitleText.text = first_titles[position]
        firstImageView.setImageResource(first_icons[position])

        return rowView
    }
}