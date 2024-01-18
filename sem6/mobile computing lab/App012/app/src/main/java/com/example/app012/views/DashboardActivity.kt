package com.example.app012.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app012.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()
    }
}