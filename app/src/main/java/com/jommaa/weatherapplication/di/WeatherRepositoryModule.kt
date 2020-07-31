package com.jommaa.weatherapplication.di

import com.jommaa.datacomponent.WeatherApi
import com.jommaa.datacomponent.WeatherRepository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherRepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepository(weatherApi)
    }
}