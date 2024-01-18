package com.example.app012.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.app012.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        val signing = findViewById<TextView>(R.id.textView2)
        signing.setOnClickListener {
            intent = Intent(applicationContext, SigninActivity::class.java)
            startActivity(intent)
        }
    }
}