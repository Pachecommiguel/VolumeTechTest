package com.pacheco.volumetechtest.data.repository

import com.pacheco.volumetechtest.data.mapper.WeatherMapper
import com.pacheco.volumetechtest.data.service.WeatherService
import com.pacheco.volumetechtest.domain.model.City
import com.pacheco.volumetechtest.domain.repository.WeatherRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherService,
    private val mapper: WeatherMapper
) : WeatherRepository {

    override suspend fun getWeather(city: City) = mapper.toModel(
        dto = service.getWeather(city = city.name),
        city = city
    )
}