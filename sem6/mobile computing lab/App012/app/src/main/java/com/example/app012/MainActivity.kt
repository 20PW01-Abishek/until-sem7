package com.example.app012

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app012.views.SigninActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        intent = Intent(applicationContext, SigninActivity::class.java)
        startActivity(intent)
    }
}