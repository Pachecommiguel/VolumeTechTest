package com.pacheco.volumetechtest.di

import com.pacheco.volumetechtest.domain.usecase.GetWeatherUseCase
import com.pacheco.volumetechtest.domain.usecase.GetWeatherUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetWeatherUseCase(usecase: GetWeatherUseCaseImp): GetWeatherUseCase

}