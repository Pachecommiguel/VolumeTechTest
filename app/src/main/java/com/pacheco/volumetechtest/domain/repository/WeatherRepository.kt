package com.pacheco.volumetechtest.domain.repository

import com.pacheco.volumetechtest.domain.model.City
import com.pacheco.volumetechtest.domain.model.WeatherModel

interface WeatherRepository {
    suspend fun getWeather(city: City): WeatherModel
}