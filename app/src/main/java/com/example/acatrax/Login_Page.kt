package com.example.acatrax

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.acatrax.databinding.ActivityLoginPageBinding
import com.example.acatrax.databinding.ActivitySignupPageBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Page : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signup.setOnClickListener{
            val intent2 = Intent(this@Login_Page, Signup_Page::class.java)
            startActivity(intent2)
        }
        binding.login.setOnClickListener{
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this@Login_Page, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Sucessfully Login", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else {
                Toast.makeText(this, "Empty fields are not allowed !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}