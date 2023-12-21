package com.capstone.cashflowmate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.capstone.cashflowmate.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.capstone.cashflowmate.databinding.ActivityLoginBinding
import com.capstone.cashflowmate.network.Resource
import com.capstone.cashflowmate.ui.viewmodel.AuthViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding  // Use the generated binding class
    private val viewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }


    private fun setupClickListeners() {
        binding.txtDaftar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            viewModel.login(email, password)
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.login.collectLatest { result ->
                        when (result) {
                            is Resource.Error -> {
                                Toast.makeText(this@LoginActivity, result.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                            is Resource.Loading -> {}
                            is Resource.Success -> {
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                            }
                            else -> {}
                        }
                    }
                }
            }
        }
    }
}