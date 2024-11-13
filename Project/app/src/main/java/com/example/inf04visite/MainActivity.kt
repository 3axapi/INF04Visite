package com.example.inf04visite

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var current_animal: String
    lateinit var alertTextView: TextView
    lateinit var seekBarTextView: TextView
    lateinit var namesEditText: EditText
    lateinit var goalEditText: EditText
    lateinit var timeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        alertTextView = findViewById(R.id.alert_textview)
        seekBarTextView = findViewById(R.id.seekbar_textview)
        namesEditText = findViewById(R.id.names_editview)
        goalEditText = findViewById(R.id.goal_textview)
        timeEditText = findViewById(R.id.time_textview)
        val oldSeekBar: SeekBar = findViewById(R.id.old_seekbar)
        val animalsListView: ListView = findViewById(R.id.animals_listview)

        oldSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarTextView.text = "${progress}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.i("seek", "Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.i("seek", "Not yet implemented")
            }
        })

        val animals = listOf("Pies", "Kot", "Świnka morska")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animals)
        animalsListView.adapter = adapter
        animalsListView.setOnItemClickListener {_, _, index, _ ->
            current_animal = animals[index]
            if (animals[index] == animals[0]) oldSeekBar.max = 18
            if (animals[index] == animals[1]) oldSeekBar.max = 20
            if (animals[index] == animals[2]) oldSeekBar.max = 9
        }
    }

    public fun alertValues(view: View) {
        alertTextView.text = "${namesEditText.text}, ${current_animal}, ${seekBarTextView.text}, ${goalEditText.text}, ${timeEditText.text}"
    }
}
