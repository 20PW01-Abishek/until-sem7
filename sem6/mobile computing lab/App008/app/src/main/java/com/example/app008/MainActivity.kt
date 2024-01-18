package com.example.app008

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        val fromdatebtn=findViewById<Button>(R.id.fromdatebtn)
        val todatebtn=findViewById<Button>(R.id.todatebtn)
        val fromdatetext=findViewById<TextView>(R.id.fromdatetext)
        val todatetext=findViewById<TextView>(R.id.todatetext)
        val caldiff=findViewById<Button>(R.id.button)

        val nDays = findViewById<TextView>(R.id.days_count)
        val nMonths = findViewById<TextView>(R.id.months_count)
        val nYears = findViewById<TextView>(R.id.years_count)

        val from_date=Calendar.getInstance();
        val to_date=Calendar.getInstance()
        fromdatebtn.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                fromdatetext.text = "" + dayOfMonth + "-" + (monthOfYear+1)+ "-" + year
                from_date.set(year,monthOfYear,dayOfMonth)
            }, year, month, day)
            dpd.show()
        }
        todatebtn.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                todatetext.text = "" + dayOfMonth + "-" + (monthOfYear+1)+ "-" + year
                to_date.set(year,monthOfYear,dayOfMonth)
            }, year, month, day)
            dpd.show()
        }

        caldiff.setOnClickListener()
        {
            val startmilli=from_date.timeInMillis
            val endmilli=to_date.timeInMillis
            val difference=endmilli-startmilli
            val diff_in_days=abs((difference/(1000*60*60*24)).toInt())
            nYears.text=(diff_in_days/365).toString()
            nMonths.text = ((diff_in_days%365)/30).toString()
            nDays.text = ((diff_in_days%365)%30).toString()
        }
    }
}