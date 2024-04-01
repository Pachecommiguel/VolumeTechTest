package com.pacheco.volumetechtest.di

import com.pacheco.volumetechtest.data.mapper.WeatherMapper
import com.pacheco.volumetechtest.data.mapper.WeatherMapperImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Singleton
    @Binds
    abstract fun bindWeatherMapper(mapper: WeatherMapperImp): WeatherMapper

}