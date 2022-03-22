package com.example.ass3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClick = findViewById<Button>(R.id.button1) //we define button
        val textClick = findViewById<TextView>(R.id.textView) //we define click text
        val textClick1 = findViewById<TextView>(R.id.textView2) // we define click text2
        var timesClick = 0 // this is how many times clicked showing
        btnClick.setOnClickListener{
            btnClick.text = "I CLIKCED" // button text
            textClick.text= "YOU CLICKED ME" //button text
            timesClick = timesClick + 1 //when click it increases one by one
            textClick1.text =timesClick.toString() // we converting an integer to a string

        }
    }


}

