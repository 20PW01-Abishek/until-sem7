package com.example.app014

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app014.Extensions.toast
import com.example.app014.FirebaseUtils.firebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()

        logout.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, WelcomeActivity::class.java))
            toast("signed out")
        }

//        val userName = findViewById<EditText>(R.id.name)
//        val userRoll = findViewById<EditText>(R.id.rollno)
//        val userCompany = findViewById<EditText>(R.id.company)
//        val userYear = findViewById<EditText>(R.id.year)
//        val userCourse = findViewById<EditText>(R.id.course)
//        val userBranch = findViewById<EditText>(R.id.branch)

        val add = findViewById<Button>(R.id.register_btn)
        val db = FirebaseFirestore.getInstance()
        data class Alumnus(
            val name: String,
            val roll_no: String,
            val course: String,
            val branch: String,
            val year: String,
            val company: String,
            )

        add.setOnClickListener {
            val note = Alumnus(name.text.toString(), rollno.text.toString(), course.text.toString(), branch.text.toString(), year.text.toString(), company.text.toString())
            val notesCollectionRef = db.collection("alumni")
            notesCollectionRef.document().set(note)
            name.setText("")
            rollno.setText("")
            course.setText("")
            branch.setText("")
            year.setText("")
            company.setText("")
            toast("Task added successfully!")
        }
    }
}