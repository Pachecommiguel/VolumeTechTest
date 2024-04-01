package com.pacheco.volumetechtest.data.mapper

import com.pacheco.volumetechtest.data.dto.WeatherDto
import com.pacheco.volumetechtest.domain.model.WeatherModel
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherMapperImp @Inject constructor() : WeatherMapper {

    override fun toModel(dto: WeatherDto?) = WeatherModel(
        city = dto?.name ?: throw Exception(),
        temp = dto.main?.temp?.roundToInt() ?: throw Exception()
    )
}