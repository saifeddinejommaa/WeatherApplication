package com.jommaa.weatherapplication.di

import com.google.gson.Gson
import com.jommaa.datacomponent.db.datasource.TownDataSource
import com.jommaa.weatherapplication.WeatherApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: WeatherApplication) {

    @Provides
    @Singleton
    fun provideApplication(): WeatherApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))

            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
    }

    @Provides
    @Singleton
    fun provideTownDataSource(): TownDataSource{
        return TownDataSource(application)
    }
}