package com.example.acatrax

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Internship_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_internship_page)

        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        button.setOnClickListener {
            val intent = Intent(this@Internship_Page, Internship_Details::class.java)
            startActivity(intent)
        }
    }
}