package com.capstone.cashflowmate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.cashflowmate.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding  // Use the generated binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtDaftarListener()
    }

    private fun txtDaftarListener() {
        binding.txtDaftar.setOnClickListener {  // Use the binding object to access views
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}