package com.pacheco.volumetechtest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pacheco.volumetechtest.domain.model.WeatherModel
import com.pacheco.volumetechtest.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    fun getWeather(onSuccess: (WeatherModel) -> Unit) {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, _ ->
            getWeather(onSuccess = onSuccess)
        }) {
            while (currentCoroutineContext().isActive) {
                onSuccess(getWeatherUseCase())
                delay(TimeUnit.HOURS.toMillis(1))
            }
        }
    }
}