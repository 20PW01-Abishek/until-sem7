package com.example.app014

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.app014.Extensions.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var signInEmail: String
    private lateinit var signInPassword: String
    private lateinit var signInInputsArray: Array<EditText>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        val signup = findViewById<TextView>(R.id.textView3)
        val login = findViewById<Button>(R.id.button)
        signInInputsArray = arrayOf(editTextTextEmailAddress, editTextTextPassword)
        login.setOnClickListener {
            signInUser()
        }
        signup.setOnClickListener {
            intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun notEmpty(): Boolean = signInEmail.isNotEmpty() && signInPassword.isNotEmpty()

    private fun signInUser() {
        signInEmail = editTextTextEmailAddress.text.toString().trim()
        signInPassword = editTextTextPassword.text.toString().trim()

        if (notEmpty()) {
            FirebaseUtils.firebaseAuth.signInWithEmailAndPassword(signInEmail, signInPassword)
                .addOnCompleteListener { signIn ->
                    if (signIn.isSuccessful) {
                        startActivity(Intent(this, DashboardActivity::class.java))
                        toast("signed in successfully")
                    } else {
                        toast("sign in failed")
                    }
                }
        } else {
            signInInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        }
    }
}