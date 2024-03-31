package com.pacheco.volumetechtest.data.mapper

import com.pacheco.volumetechtest.data.dto.WeatherDto
import com.pacheco.volumetechtest.domain.model.WeatherModel
import javax.inject.Inject

class WeatherMapperImp @Inject constructor() : WeatherMapper {

    override fun toModel(dto: WeatherDto) = WeatherModel(
        city = dto.name,
        temp = dto.main.temp
    )
}