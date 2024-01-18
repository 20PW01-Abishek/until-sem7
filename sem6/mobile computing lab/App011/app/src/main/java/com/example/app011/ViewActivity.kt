package com.example.app011

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ViewActivity : AppCompatActivity() {
    @SuppressLint("Range", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        if (supportActionBar != null) {
            supportActionBar?.hide()
        }
        val roll = findViewById<TextView>(R.id.Roll)
        val name = findViewById<TextView>(R.id.Name)
        val mark = findViewById<TextView>(R.id.Mark)
        val close = findViewById<TextView>(R.id.button)
        val db = DBHelper(this, null)
        val cursor = db.getDetail()
        cursor!!.moveToFirst()
        roll.append(cursor.getString(cursor.getColumnIndex(DBHelper.ROLL_COL)) + "\n")
        name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
        mark.append(cursor.getString(cursor.getColumnIndex(DBHelper.MARK_COL)) + "\n")
        while(cursor.moveToNext()){
            roll.append(cursor.getString(cursor.getColumnIndex(DBHelper.ROLL_COL)) + "\n")
            name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
            mark.append(cursor.getString(cursor.getColumnIndex(DBHelper.MARK_COL)) + "\n")
        }
        cursor.close()
        close.setOnClickListener {
            this.finish()
        }
    }
}