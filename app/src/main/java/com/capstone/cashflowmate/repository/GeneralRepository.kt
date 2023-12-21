package com.capstone.cashflowmate.repository

import com.capstone.cashflowmate.network.ApiService
import com.capstone.cashflowmate.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GeneralRepository (
    private val apiService: ApiService
){
    suspend fun login(
        email: String,
        password: String
    ) = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.login(email, password)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun register(
        email: String,
        password: String,
        nama: String,
        id_daerah: String
    ) = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.register(email, password, nama, id_daerah)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDaerah() = apiService.getDaerah()
}