package com.example.e6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fName = findViewById<EditText>(R.id.editTextTextPersonName)
        val lName = findViewById<EditText>(R.id.editTextTextPersonName2)
        val phone = findViewById<EditText>(R.id.editTextPhone)
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val bday = findViewById<EditText>(R.id.editTextDate)
        val gender = findViewById<Spinner>(R.id.spinner)
        val postal = findViewById<EditText>(R.id.editTextTextPostalAddress)
        val submitBtn = findViewById<Button>(R.id.button)

        // populate the spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.genders,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            gender.adapter = adapter
        }


        submitBtn.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MiddleActivity::class.java);
            intent.putExtra("fName", fName.text.toString());
            intent.putExtra("lName", lName.text.toString());
            intent.putExtra("phone", phone.text.toString());
            intent.putExtra("email", email.text.toString());
            intent.putExtra("bday", bday.text.toString());
            intent.putExtra("gender", gender.selectedItem.toString());
            intent.putExtra("postal", postal.text.toString());
            startActivity(intent);
        }
    }
}