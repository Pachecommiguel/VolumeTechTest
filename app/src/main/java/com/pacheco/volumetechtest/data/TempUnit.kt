package com.pacheco.volumetechtest.data

sealed class TempUnit(open val name: String) {
    data class Metric(override val name: String = "metric"): TempUnit(name = name)
}