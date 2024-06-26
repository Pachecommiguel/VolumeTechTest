package com.pacheco.volumetechtest.di

import com.pacheco.volumetechtest.data.repository.WeatherRepositoryImp
import com.pacheco.volumetechtest.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindWeatherRepository(repository: WeatherRepositoryImp): WeatherRepository

}