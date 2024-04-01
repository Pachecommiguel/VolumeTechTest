package com.pacheco.volumetechtest.data.service

import com.pacheco.volumetechtest.data.Endpoint
import com.pacheco.volumetechtest.data.RetrofitClient
import com.pacheco.volumetechtest.data.TempUnit
import com.pacheco.volumetechtest.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(Endpoint.WEATHER)
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") id: String = RetrofitClient.API_KEY,
        @Query("units") unit: String = TempUnit.Metric().name
    ): WeatherDto?
}