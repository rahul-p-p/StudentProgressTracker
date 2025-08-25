package com.example.acatrax

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        val signup=findViewById<Button>(R.id.signup)

        signup.setOnClickListener(){
            val intent = Intent(this@Login_Page, Signup_Page::class.java)
            startActivity(intent)
        }
    }
}