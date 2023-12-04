package com.capstone.cashflowmate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.cashflowmate.MainActivity
import com.capstone.cashflowmate.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding  // Use the generated binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }


    private fun setupClickListeners() {
        binding.txtDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnSignUp.setOnClickListener {
            // Handle login logic if needed
            // For now, just navigate to MainActivity
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}