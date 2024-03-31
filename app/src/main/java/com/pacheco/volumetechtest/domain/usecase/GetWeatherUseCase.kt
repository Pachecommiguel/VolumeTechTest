package com.pacheco.volumetechtest.domain.usecase

import com.pacheco.volumetechtest.domain.model.WeatherModel

interface GetWeatherUseCase {
    suspend operator fun invoke(): WeatherModel
}