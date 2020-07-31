package com.jommaa.weatherapplication.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jommaa.datacomponent.Results.WeatherDetailsResult
import com.jommaa.datacomponent.WeatherRepository.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsViewModel  @Inject constructor(val weatherRepository: WeatherRepository) : ViewModel() {


    val progressVisible = ObservableBoolean()
    var townName = ObservableField<String>()
    var pressure = ObservableField<String>()
    var humidity = ObservableField<String>()
    var temp = ObservableField<String>()
    var visibility = ObservableField<String>()


    fun bound(townName:String,lat: Double, long: Double) {
        this.townName.set(townName)
        weatherRepository.getWeatherDetails(lat,long,"metric")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleGetRestaurantListResult(it) }
    }

    private fun handleGetRestaurantListResult(result: WeatherDetailsResult) {
        progressVisible.set(result == WeatherDetailsResult.Loading)
        when (result) {
            is WeatherDetailsResult.Success -> {
                pressure.set("Pressure: "+result.details.current.pressure+" hPa")
                humidity.set("Humidity: "+result.details.current.pressure+" %")
                visibility.set("Visibility: "+result.details.current.visibility+" meters")
                temp.set(result.details.current.temp.toString() +" C°")
            }
            is WeatherDetailsResult.Failure -> {
                Log.d("Erreur", "connot find city weather details")
            }
        }
    }

}