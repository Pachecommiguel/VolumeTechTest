package com.pacheco.volumetechtest.domain.model

import java.util.*

data class WeatherModel(
    val city: String,
    val temp: Int,
    private val uuid: UUID = UUID.randomUUID()
) {
    override fun equals(other: Any?) = (other as? WeatherModel)?.uuid == this.uuid
    override fun hashCode() = temp.hashCode()
}
