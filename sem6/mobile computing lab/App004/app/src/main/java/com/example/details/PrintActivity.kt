package com.example.details

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PrintActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print)
        val bundle: Bundle? = intent.extras
        val f = findViewById<TextView>(R.id.textView4)
        val l = findViewById<TextView>(R.id.textView5)
        val visitType = findViewById<TextView>(R.id.textView6)
        val country = findViewById<TextView>(R.id.textView7)
        val btn3 = findViewById<Button>(R.id.button3)
        val f_name = bundle?.get("fname")
        val l_name = bundle?.get("lname")
        val v_name = bundle?.get("visit")
        val c_name = bundle?.get("country")

        f.text = "First name: $f_name"
        l.text = "Last name: $l_name"
        visitType.text = "Visit type: ${v_name.toString()}"
        country.text = "Country: $c_name"

        btn3.setOnClickListener(){
            finish()
        }
    }
}