package com.example.listapp

import android.content.DialogInterface
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val first_titles = arrayOf<String>("apple","banana","mango","orange","avocado")
    private val first_descriptions = arrayOf<String>("An apple a day keeps the doctor away",
                                            "An old banana leaf was once young and green",
                                            "You don't throw rocks at a green mango",
                                            "When life gives you lemons....they could really be oranges.",
                                            "If you have nothing but love for your avocados, and you take joy in turning them into guacamole, all you need is someone to share it with.")
    private val first_icons = arrayOf<Int>(R.drawable.apple, R.drawable.banana, R.drawable.mango, R.drawable.orange, R.drawable.avocado)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myListAdapter = MyListAdapter(this, first_titles, first_icons)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            //Display Toast for Debugging
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_SHORT).show()

            //Create and Show Dialog Function
            createDialog(position)

            //Use Notification sound as Sound
            val alarmSound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

            // Play Sound
            val mediaPlayer = MediaPlayer.create(this, alarmSound)
            mediaPlayer?.start()
        }
    }

    private fun createDialog(pos : Int){
        val builder: AlertDialog.Builder? = this?.let {
            AlertDialog.Builder(it)
        }

        // 2. Chain together various setter methods to set the dialog characteristics
        builder?.setMessage(first_descriptions[pos])
            ?.setTitle("Quote")

        builder?.setNeutralButton("Back",
            DialogInterface.OnClickListener { dialog, id ->
                // User clicked OK button
            }
        )
        val dialog: AlertDialog? = builder?.create()

        builder?.show()

    }

}