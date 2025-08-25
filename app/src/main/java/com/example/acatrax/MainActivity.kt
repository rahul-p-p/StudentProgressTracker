package com.example.acatrax

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val internship=findViewById<CardView>(R.id.internships)
            internship.setOnClickListener {
                val intent= Intent(this@MainActivity, Internship_Page::class.java)
                startActivity(intent)
            }
    }
}