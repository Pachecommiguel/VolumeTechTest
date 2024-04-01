package com.pacheco.volumetechtest.data.mapper

import com.pacheco.volumetechtest.data.dto.WeatherDto
import com.pacheco.volumetechtest.domain.model.WeatherModel

interface WeatherMapper {
    fun toModel(dto: WeatherDto?): WeatherModel
}