package com.jommaa.datacomponent.dataResponse
  open abstract class WeatherStatusResponse(
      open val dt : Long,
      open val sunrise :Long,
      open val sunset : Long,
      open val pressure: Int,
      open val humidity: Int,
      open val dewPoint: Float,
      open val uvi: Float,
      open val clouds: Int,
      open val windSpeed: Float,
      open val winDeg: Int,
      open val weatherResponse: Array<WeatherResponse>,
      open val pop: Float ) {
}