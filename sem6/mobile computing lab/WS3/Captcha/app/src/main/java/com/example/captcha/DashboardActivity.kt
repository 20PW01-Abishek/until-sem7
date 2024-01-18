package com.example.captcha

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val bundle: Bundle? = intent.extras
        val t = findViewById<TextView>(R.id.textView4)
        var phno = bundle?.get("phno")
        t.text = "$phno"
    }
}