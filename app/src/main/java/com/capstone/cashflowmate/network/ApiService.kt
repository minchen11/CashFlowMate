package com.capstone.cashflowmate.network

import com.capstone.cashflowmate.response.GetDaerahResponse
import com.capstone.cashflowmate.response.LoginResponse
import com.capstone.cashflowmate.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email :  String,
        @Field("password") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("user")
    suspend fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field ("nama") nama: String,
        @Field ("id_daerah") id_daerah: String
    ): RegisterResponse

    @GET("daerah")
    fun getDaerah(): GetDaerahResponse
}