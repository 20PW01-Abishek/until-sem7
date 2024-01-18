package com.example.app014

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app014.Extensions.toast
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        supportActionBar?.hide()
        logout.setOnClickListener {
            FirebaseUtils.firebaseAuth.signOut()
            startActivity(Intent(this, WelcomeActivity::class.java))
            toast("signed out")
            finish()
        }
    }
}