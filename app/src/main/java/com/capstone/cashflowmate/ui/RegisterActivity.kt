package com.capstone.cashflowmate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.cashflowmate.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding  // Use the generated binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root) // use this instead setContentView(R.layout.activity_register)

        btnBackRegisterListener()
        txtLoginListener()
    }

    private fun btnBackRegisterListener() {
        binding.btnBack.setOnClickListener {  // Use the binding object to access views
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun txtLoginListener() {
        binding.txtLogin.setOnClickListener {  // Use the binding object to access views
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }



}