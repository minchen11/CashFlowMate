package com.capstone.cashflowmate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.cashflowmate.MainActivity
import android.content.Intent as intent
import com.capstone.cashflowmate.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding  // Use the generated binding class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root) // use this instead setContentView(R.layout.activity_register

        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        binding.btnBackProfile.setOnClickListener {
            startActivity(intent(this, MainActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            startActivity(intent(this, LoginActivity::class.java))
        }
    }



}