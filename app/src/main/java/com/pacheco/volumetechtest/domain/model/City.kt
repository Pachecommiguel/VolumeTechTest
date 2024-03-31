package com.pacheco.volumetechtest.domain.model

sealed class City(open val name: String) {
    data class London(override val name: String = "London"): City(name = name)
}