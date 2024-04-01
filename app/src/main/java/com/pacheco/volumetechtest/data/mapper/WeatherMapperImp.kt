package com.pacheco.volumetechtest.data.mapper

import com.pacheco.volumetechtest.data.dto.WeatherDto
import com.pacheco.volumetechtest.domain.model.City
import com.pacheco.volumetechtest.domain.model.WeatherModel
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherMapperImp @Inject constructor() : WeatherMapper {

    override fun toModel(dto: WeatherDto?, city: City): WeatherModel {
        if (dto?.name == null || dto.main?.temp == null) {
            throw Exception()
        }

        return WeatherModel(
            city = dto.name.ifBlank(city::name),
            temp = dto.main.temp.roundToInt()
        )
    }
}