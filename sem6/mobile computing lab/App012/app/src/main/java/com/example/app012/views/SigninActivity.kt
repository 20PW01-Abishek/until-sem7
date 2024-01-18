package com.example.app012.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app012.R

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.hide()
        val signup = findViewById<Button>(R.id.button2)
        signup.setOnClickListener {
            intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}