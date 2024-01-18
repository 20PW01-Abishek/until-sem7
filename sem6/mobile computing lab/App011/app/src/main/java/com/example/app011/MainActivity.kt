package com.example.app011

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar?.hide()
        }

        val addName = findViewById<Button>(R.id.button)
        val printName = findViewById<Button>(R.id.button4)
        val update = findViewById<Button>(R.id.button2)
        val delete = findViewById<Button>(R.id.button3)
        val clear = findViewById<Button>(R.id.button5)
        val enterRoll = findViewById<EditText>(R.id.roll)
        val enterName = findViewById<EditText>(R.id.editTextTextPersonName2)
        val enterMark = findViewById<EditText>(R.id.editTextNumber)

        addName.setOnClickListener {
            val db = DBHelper(this, null)
            val roll = enterRoll.text.toString()
            val name = enterName.text.toString()
            val mark = enterMark.text.toString()
            if (roll != "" && name != "" && mark != "") {
                db.addDetail(roll, name, mark)
                Toast.makeText(this, "$roll details added", Toast.LENGTH_SHORT).show()
                enterRoll.text.clear()
                enterName.text.clear()
                enterMark.text.clear()
            }else{
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            }
            enterRoll.isEnabled = true
        }

        printName.setOnClickListener{
            intent = Intent(applicationContext,ViewActivity::class.java)
            startActivity(intent)
            enterRoll.isEnabled = true
        }

        update.setOnClickListener {
            val roll = enterRoll.text.toString()
            if (roll == "") {
                Toast.makeText(this, "Please fill the roll-no to fetch details", Toast.LENGTH_SHORT)
                    .show()
                enterRoll.isEnabled = true
            } else {
                if (update.text == "Fetch"){
                    update.text = "Update"
                    enterRoll.isEnabled = false
                    val db = DBHelper(this,null)
                    val cursor = db.fetchDetail(roll)
                    if (cursor != null) {
                        cursor.moveToFirst()
                        val n = cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)).toString()
                        val m = cursor.getString(cursor.getColumnIndex(DBHelper.MARK_COL)).toString()
                        enterName.setText(n)
                        enterMark.setText(m)
                        cursor.close()
                    }else{
                        Toast.makeText(this, "$roll details doesn't exist", Toast.LENGTH_SHORT).show()
                        enterRoll.text.clear()
                        enterRoll.isEnabled = true
                    }
                }else {
                    update.text = "Fetch"
                    val db = DBHelper(this, null)
                    val name = enterName.text.toString()
                    val mark = enterMark.text.toString()
                    if (name != "") {
                        db.updateDetail(roll, name, mark)
                        Toast.makeText(this, "$roll details updated", Toast.LENGTH_SHORT).show()
                        enterRoll.text.clear()
                        enterName.text.clear()
                        enterMark.text.clear()
                    } else {
                        Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT)
                            .show()
                    }
                    enterRoll.isEnabled = true
                }
            }
        }

        delete.setOnClickListener {
            val db = DBHelper(this,null)
            val roll = enterRoll.text.toString()
            db.deleteDetail(roll)
            Toast.makeText(this, "$roll details deleted", Toast.LENGTH_SHORT).show()
            enterRoll.text.clear()
            enterName.text.clear()
            enterMark.text.clear()
            enterRoll.isEnabled = true
        }

        clear.setOnClickListener {
            enterRoll.text.clear()
            enterName.text.clear()
            enterMark.text.clear()
            enterRoll.isEnabled = true
        }
    }
}
