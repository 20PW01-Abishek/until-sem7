package com.example.cookie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img = findViewById<ImageView>(R.id.imageView);
        val btn = findViewById<Button>(R.id.button);

        btn.setOnClickListener {
            if(btn.text == "TURN ON") {
                btn.text = "TURN OFF";
                img.setImageResource(R.drawable.img2);
            } else {
                btn.text = "TURN ON";
                img.setImageResource(R.drawable.img1);
            }
        }
    }
}