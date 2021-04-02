package com.jommaa.weatherapplication.di


import com.jommaa.weatherapplication.view.AddNewTownActivity
import com.jommaa.weatherapplication.view.BaseActivity
import com.jommaa.weatherapplication.view.MainActivity
import com.jommaa.weatherapplication.view.TownDetailActivity
import com.jommaa.weatherapplication.view.fragment.WeatherDetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, WeatherRepositoryModule::class, WeatherEndPointModule::class,TownRepositoryModule::class])
interface ApplicationComponent {


    fun inject(app: AddNewTownActivity)
    fun inject(app: MainActivity)
    fun inject(app: TownDetailActivity)
    fun inject(fragment:WeatherDetailFragment)
    fun inject(app:BaseActivity)
}