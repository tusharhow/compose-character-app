package com.example.characterapp.network

import com.example.characterapp.Constants.AppConstants
import retrofit2.Retrofit

class ApiServiceImpl {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
        }
        val api by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}