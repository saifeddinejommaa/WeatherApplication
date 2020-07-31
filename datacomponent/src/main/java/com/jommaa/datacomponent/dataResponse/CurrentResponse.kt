package com.jommaa.datacomponent.dataResponse

import com.google.gson.annotations.SerializedName

data class CurrentResponse(
      val dt : Long,
      val sunrise :Long,
      val sunset : Long,
      val pressure: Int,
      val humidity: Int,
    @SerializedName("dew_point")
      val dewPoint: Float,
      val uvi: Float,
      val clouds: Int,
    @SerializedName("wind_speed")
      val windSpeed: Float,
    @SerializedName("wind_deg")
      val winDeg: Int,
    @SerializedName("weather")
      val weatherResponse: Array<WeatherResponse>?,
      val pop: Float,
    val temp : Float,
    @SerializedName("feels_like")
    val feelLike : Float,
    val visibility: Int
)  {
}