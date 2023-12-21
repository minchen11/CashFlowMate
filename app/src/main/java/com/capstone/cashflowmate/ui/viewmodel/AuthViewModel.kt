package com.capstone.cashflowmate.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.cashflowmate.network.Resource
import com.capstone.cashflowmate.repository.GeneralRepository
import com.capstone.cashflowmate.response.LoginResponse
import com.capstone.cashflowmate.response.RegisterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: GeneralRepository) : ViewModel() {
    private var _login = MutableStateFlow<Resource<LoginResponse>>(Resource.Loading())
    val login: StateFlow<Resource<LoginResponse>> get() = _login

    private var _register = MutableStateFlow<Resource<RegisterResponse>>(Resource.Loading())
    val register get() = _register

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        val response = repository.login(email, password)
        response.collect {
            _login.value = it
        }
    }

    fun register(
        email: String,
        password: String,
        nama: String,
        id_daerah: String
    ) = viewModelScope.launch {
        val response = repository.register(email, password, nama, id_daerah)
        response.collect {
            _register.value = it
        }
    }
}