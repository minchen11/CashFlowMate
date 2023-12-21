package com.capstone.cashflowmate.di

import com.capstone.cashflowmate.BuildConfig
import com.capstone.cashflowmate.network.ApiService
import com.capstone.cashflowmate.repository.GeneralRepository
import com.capstone.cashflowmate.ui.viewmodel.AuthViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        GsonBuilder()
            .setLenient()
            .create()
    }

    single {

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)

    }


}

val repositoryModule = module {
    single { GeneralRepository(get()) }
}

val viewModelModule = module {
    viewModel {
        AuthViewModel(get())
    }
}
