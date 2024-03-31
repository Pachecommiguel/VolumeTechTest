package com.pacheco.volumetechtest.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val API_KEY = "433f0a05409361125a827f77654820e4"

    private val INSTANCE: Retrofit = Retrofit.Builder()
        .baseUrl(Endpoint.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(classType: Class<T>): T = INSTANCE.create(classType)
}