package com.example.feedback

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar?.hide();
        }
        val rBar = findViewById<RatingBar>(R.id.ratingBar)
        val t = findViewById<TextView>(R.id.textView2)
        val rating = rBar.rating.toInt()
        val b = findViewById<Button>(R.id.button)
        val feedback = findViewById<EditText>(R.id.feedback1)
        val countText = findViewById<TextView>(R.id.countText)
        feedback.visibility = View.INVISIBLE
        countText.visibility = View.INVISIBLE
        rBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                if (rating > 4)
                    t.text = resources.getString(R.string.rat_s1)
                else if (rating > 3)
                    t.text = resources.getString(R.string.rat_s2)
                else if (rating > 2)
                    t.text = resources.getString(R.string.rat_s3)
                else if (rating > 1)
                    t.text = resources.getString(R.string.rat_s4)
                else if (rating > 0)
                    t.text = resources.getString(R.string.rat_s5)
                else
                    t.text = resources.getString(R.string.rat_def)
                feedback.visibility = View.VISIBLE
                countText.visibility = View.VISIBLE
                feedback.addTextChangedListener(object: TextWatcher{
                    @SuppressLint("SetTextI18n")
                    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                        var length = 100-feedback.length()
                        countText.text = "$length/100"
                        if (countText.text.equals("0/100")){
                            feedback.isEnabled = false
                        }
                    }
                    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    }
                    override fun afterTextChanged(s: Editable) {

                    }
                })
            }
        b.setOnClickListener{
            if (rBar.rating == 0F) {
                Toast.makeText(applicationContext,"Please rate before submitting",Toast.LENGTH_SHORT).show();
            } else {
                t.text = resources.getString(R.string.rat_def)
                feedback.setText("")
                countText.text = "0/100"
                rBar.rating = 0F
                Toast.makeText(applicationContext, "Thanks for your feedback!", Toast.LENGTH_SHORT).show();
                feedback.visibility = View.INVISIBLE
                countText.visibility = View.INVISIBLE
            }
        }
    }
}