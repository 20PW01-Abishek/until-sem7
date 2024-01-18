package com.example.details

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    @SuppressLint("DiscouragedPrivateApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fname = findViewById<TextView>(R.id.fname)
        val lname = findViewById<TextView>(R.id.lname)
        val visitType = findViewById<RadioGroup>(R.id.visitType)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btn1 = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)

        ArrayAdapter.createFromResource(
            this, R.array.countries, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        btn1.setOnClickListener {
            if(isAlphabet(fname.text.toString()).not() || fname.text.toString()==""){
                Toast.makeText(applicationContext, "Invalid first name", Toast.LENGTH_SHORT).show()
            }
            else if (isAlphabet(lname.text.toString()).not() || lname.text.toString()==""){
                Toast.makeText(applicationContext, "Invalid last name", Toast.LENGTH_SHORT).show()
            }
            else if(visitType.checkedRadioButtonId==-1){
                Toast.makeText(applicationContext, "Select a visit type", Toast.LENGTH_SHORT).show()
            }
            else if(spinner.selectedItemId==0L){
                Toast.makeText(applicationContext, "Select a country", Toast.LENGTH_SHORT).show()
            }
            else {
                intent = Intent(this, PrintActivity::class.java)
                intent.putExtra("fname", fname.text.toString())
                intent.putExtra("lname", lname.text)
                intent.putExtra("visit", findViewById<RadioButton>(visitType.checkedRadioButtonId).text.toString())
                intent.putExtra("country", spinner.selectedItem.toString())
                startActivity(intent)
            }
        }

        btn2.setOnClickListener {
            fname.text=""
            lname.text=""
            visitType.clearCheck()
            spinner.setSelection(0)
        }
    }
    private fun isAlphabet(string: String): Boolean {
        return string.matches("^[a-zA-Z]*$".toRegex())
    }
}