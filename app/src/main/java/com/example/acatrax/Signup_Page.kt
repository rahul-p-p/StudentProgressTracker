package com.example.acatrax

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.acatrax.databinding.ActivitySignupPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import java.net.Authenticator


class Signup_Page : AppCompatActivity() {

    private lateinit var binding: ActivitySignupPageBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignupPageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.gotologin.setOnClickListener {
            val intent = Intent(this@Signup_Page, Login_Page::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()
            val cpass = binding.cpassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && cpass.isNotEmpty()) {
                if (pass == cpass) {
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this@Signup_Page, Login_Page::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Sucessfully Signup", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else
                    Toast.makeText(this, "Password is not maching", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Empty fields are not allowed !", Toast.LENGTH_SHORT).show()
            }
        }

    }
}