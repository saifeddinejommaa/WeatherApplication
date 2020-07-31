package com.jommaa.datacomponent.WeatherRepository

import com.jommaa.datacomponent.Results.WeatherDetailsResult
import com.jommaa.datacomponent.WeatherApi
import io.reactivex.Observable

open class WeatherRepository(
    private val weatherApi: WeatherApi
)  {

    fun getWeatherDetails(lat: Double,lng: Double,units: String) : Observable<WeatherDetailsResult> {
        return weatherApi.getWeatherDetails(lat,lng,units)
            .toObservable()
            .map { WeatherDetailsResult.Success(it) as WeatherDetailsResult }
            .onErrorReturn { WeatherDetailsResult.Failure(it) }
            .startWith(WeatherDetailsResult.Loading)
    }
}