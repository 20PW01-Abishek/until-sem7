package com.example.captcha

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar?.hide();
        }
        val mobileField= findViewById<EditText>(R.id.editTextNumber)
        val captchaField=findViewById<TextView>(R.id.captchaDisplay)
        val userInput=findViewById<EditText>(R.id.captcha)
        val submitBtn=findViewById<Button>(R.id.button)
        val refreshBtn = findViewById<Button>(R.id.button2)
        captchaField.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            text = makeCaptcha();
            refreshBtn.setOnClickListener {
                text = makeCaptcha();
            }
            submitBtn.setOnClickListener {
                if (mobileField.text.toString().matches(Regex("^([+]\\d{2})?\\d{10}\$"))) {
                    if(userInput.text.toString() == captchaField.text.toString()) {
                        intent = Intent(applicationContext, DashboardActivity::class.java)
                        intent.putExtra("phno", mobileField.text.toString())
                        Toast.makeText(applicationContext, mobileField.text.toString()+" Success!", Toast.LENGTH_SHORT).show()
                        mobileField.setText("")
                        text=makeCaptcha()
                        userInput.setText("")
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Wrong captcha!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(applicationContext, "Invalid mobile number!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    private fun makeCaptcha(): String {
        var captcha=""
        for(i in 1..6)
        {
            captcha+=(0..9).random()
        }
        return captcha;
    }
}