package com.example.temperature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = findViewById<EditText>(R.id.cel)
        val f = findViewById<EditText>(R.id.fah)
        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener {
            if (c.isFocused){
                if (c.text.toString()=="") {
                    Toast.makeText(applicationContext,"Invalid input",Toast.LENGTH_SHORT).show();
                    return@setOnClickListener
                }
                var cel = c.text.toString().toDouble()
                var fah = (9/5)*cel + 32
                f.setText(fah.toString())
                Toast.makeText(applicationContext,"celsius to fahrenheit",Toast.LENGTH_SHORT).show();
            }
            if (f.isFocused){
                if (f.text.toString()=="") {
                    return@setOnClickListener
                }
                var fah = f.text.toString().toDouble()
                var cel = (fah-32)*5/9
                c.setText(cel.toString())
                Toast.makeText(applicationContext,"fahrenheit to celsius",Toast.LENGTH_SHORT).show();
            }
        }
    }
}