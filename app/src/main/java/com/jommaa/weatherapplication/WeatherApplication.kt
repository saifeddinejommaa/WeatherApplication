package com.jommaa.weatherapplication

import android.app.Application
import com.jommaa.weatherapplication.di.ApplicationComponent
import com.jommaa.weatherapplication.di.ApplicationModule
import com.jommaa.weatherapplication.di.DaggerApplicationComponent
import javax.inject.Inject

class  WeatherApplication @Inject constructor() : Application() {

        lateinit var component: ApplicationComponent



    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)).build()
    }



}