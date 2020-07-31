package com.jommaa.weatherapplication.di

import com.jommaa.datacomponent.WeatherEndPoint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class WeatherEndPointModule {
    @Provides
    @Singleton
    fun provideWeatherEndPoint(retrofit: Retrofit): WeatherEndPoint {
        return retrofit
            .create(WeatherEndPoint::class.java)
    }
}