package com.pacheco.volumetechtest.data.di

import com.pacheco.volumetechtest.data.RetrofitClient
import com.pacheco.volumetechtest.data.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideWeatherService(): WeatherService = RetrofitClient.create(classType = WeatherService::class.java)
}