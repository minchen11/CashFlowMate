package com.capstone.cashflowmate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.capstone.cashflowmate.MainActivity
import com.capstone.cashflowmate.databinding.ActivityRegisterBinding
import com.capstone.cashflowmate.network.Resource
import com.capstone.cashflowmate.ui.viewmodel.AuthViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding  // Use the generated binding class
    private val viewModel: AuthViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root) // use this instead setContentView(R.layout.activity_register)

        btnBackRegisterListener()
        txtLoginListener()

        binding.btnSignUp.setOnClickListener {
            setup()
        }
    }

    private fun setup() {
        binding.apply {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val name = edtFullname.text.toString()
            val daerah = edtDaerah.text.toString()
            viewModel.register(email, password, name, daerah)
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.register.collectLatest { result ->
                        when (result) {
                            is Resource.Error -> {
                                Toast.makeText(this@RegisterActivity, result.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                            is Resource.Loading -> {}
                            is Resource.Success -> {
                                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                startActivity(intent)
                            }
                            else -> {}
                        }
                    }
                }
            }
        }
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