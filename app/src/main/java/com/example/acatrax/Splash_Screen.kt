package com.example.acatrax

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun animateTyping(textView: TextView, text: String, delay: Long = 100) {
            textView.text = ""
            var i = 0
            val handler = Handler(Looper.getMainLooper())
            val runnable = object : Runnable {
                override fun run() {
                    if (i <= text.length) {
                        textView.text = text.substring(0, i)
                        i++
                        handler.postDelayed(this, delay)
                    }
                }
            }
            handler.post(runnable)
        }

// Usage
        animateTyping(findViewById(R.id.tagline), "Track. Analyze. Excel.")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splash_Screen, Login_Page::class.java)
            startActivity(intent)
            finish() // closes splash so user can’t go back
        }, 6000)

    }
}