package com.example.app014

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.app014.Extensions.toast
import com.example.app014.FirebaseUtils.firebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var createAccountInputsArray: Array<EditText>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        val login = findViewById<TextView>(R.id.textView3)
        createAccountInputsArray = arrayOf(editTextTextEmailAddress, editTextTextPassword, editTextTextPassword2)
        val signUp = findViewById<Button>(R.id.button)
        signUp.setOnClickListener {
            createAccount()
        }
        login.setOnClickListener {
            toast("Please sign into your account")
        }
    }

    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = firebaseAuth.currentUser
        user?.let {
            startActivity(Intent(this, DashboardActivity::class.java))
            toast("Welcome back")
        }
    }

    private fun notEmpty(): Boolean = editTextTextEmailAddress.text.toString().trim().isNotEmpty() &&
            editTextTextPassword.text.toString().trim().isNotEmpty() &&
            editTextTextPassword2.text.toString().trim().isNotEmpty()

    private fun identicalPassword(): Boolean {
        var identical = false
        if (notEmpty() &&
            editTextTextPassword.text.toString().trim() == editTextTextPassword2.text.toString().trim()
        ) {
            identical = true
        } else if (!notEmpty()) {
            createAccountInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        } else {
            toast("Passwords doesn't match!")
        }
        return identical
    }
    private fun createAccount() {
        if (identicalPassword()) {
            userEmail = editTextTextEmailAddress.text.toString().trim()
            userPassword = editTextTextPassword.text.toString().trim()

            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        toast("Account created successfully!")
                        startActivity(Intent(this, DashboardActivity::class.java))
                    } else {
                        toast("User already exists!")
                    }
                }
        }
    }
}