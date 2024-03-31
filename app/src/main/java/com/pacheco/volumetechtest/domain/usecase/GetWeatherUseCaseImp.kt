package com.pacheco.volumetechtest.domain.usecase

import com.pacheco.volumetechtest.domain.model.City
import com.pacheco.volumetechtest.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCaseImp @Inject constructor(
    private val repository: WeatherRepository
): GetWeatherUseCase {

    override suspend fun invoke() = repository.getWeather(city = City.London())
}