package com.example.e6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MiddleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle)

        val displayField = findViewById<TextView>(R.id.textView2);
        val editBtn = findViewById<Button>(R.id.button2);
        val saveBtn = findViewById<Button>(R.id.button3);

        val intent = intent;
        var str = "{\n\t\t\tfName:";
        str += intent.getStringExtra("fName");
        str += ",\n\t\t\tlName:";
        str += intent.getStringExtra("lName");
        str += ",\n\t\t\tphone:";
        str += intent.getStringExtra("phone");
        str += ",\n\t\t\temail:";
        str += intent.getStringExtra("email");
        str += ",\n\t\t\tbdate:";
        str += intent.getStringExtra("bday");
        str += ",\n\t\t\tgender:";
        str += intent.getStringExtra("gender");
        str += ",\n\t\t\taddress:";
        str += intent.getStringExtra("postal");
        str += ",\n}";

        displayField.text = str;

        editBtn.setOnClickListener {
            finish();
        }

        saveBtn.setOnClickListener {
            val intent2: Intent = Intent(applicationContext, FinalActivity::class.java);
            intent2.putExtra("fName", intent.getStringExtra("fName"));
            intent2.putExtra("lName", intent.getStringExtra("lName"));
            startActivity(intent2);
        }

    }
}