package com.example.e6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val resultField = findViewById<TextView>(R.id.textView3)
        val intent2 = intent;

        resultField.text = intent2.getStringExtra("fName") + " " + intent2.getStringExtra("lName") + " registered as new user."
    }
}