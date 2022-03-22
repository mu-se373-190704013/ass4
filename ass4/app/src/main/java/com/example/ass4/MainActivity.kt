package com.example.ass4

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? =null //define date textview
    private var tvAgeInMinutes : TextView? =null // define date minute textview

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDAtePicker : Button = findViewById(R.id.button1) // define date clicker button
        tvSelectedDate= findViewById(R.id.tvSelectedDate) //define date textview
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes) // define date minute textview

        btnDAtePicker.setOnClickListener {
            clickDatePicker()

        }

    }

     fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR) // define year
        val month = myCalendar.get(Calendar.MONTH) //define month
        val day = myCalendar.get(Calendar.DAY_OF_MONTH) //define day
        val dpd = DatePickerDialog(this,
            { view, year, month, dayOfMonth ->

                Toast.makeText(this,"$dayOfMonth/${month+1}/$year",Toast.LENGTH_LONG).show()  //just showıng notification

                val selectedDate= "$dayOfMonth/${month+1}/$year"  //we sleecting date
                tvSelectedDate?.text=selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                val theDate=sdf.parse(selectedDate)
                theDate?.let {
                    val selectedDateInMinutes = theDate.time/60000  //we calculate mınutes

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time/60000  //we calculate date

                        val differentInMinutes = currentDateInMinutes - selectedDateInMinutes

                        tvAgeInMinutes?.text=differentInMinutes.toString()  //how many mınutes lives we see
                    }

                }

            },

            year,
            month,
            day
        )
         dpd.datePicker.maxDate=System.currentTimeMillis()-86400000  //we can't choose from the future
         dpd.show()


    }
}