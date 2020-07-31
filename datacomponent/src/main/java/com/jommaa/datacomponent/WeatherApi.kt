package com.jommaa.datacomponent

import com.jommaa.datacomponent.dataResponse.WeatherDetailsResponse
import com.jommaa.datacomponent.consts.Consts
import io.reactivex.Single
import javax.inject.Inject

class WeatherApi @Inject constructor(private val weatherEndPoint: WeatherEndPoint) {

  fun getWeatherDetails(lat: Double,lng: Double,units: String) : Single<WeatherDetailsResponse> {
      return weatherEndPoint.getWeatherDetails(lat,lng,"hourly,daily", Consts.APP_KEY,units)
  }
}