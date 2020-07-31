package com.jommaa.datacomponent.WeatherObjects

data class Current(
    override val dt : Long,
    override val sunrise :Long,
    override val sunset : Long,
    override val pressure: Int,
    override val humidity: Int,
    override val dewPoint: Float,
    override val uvi: Float,
    override val clouds: Int,
    override val windSpeed: Float,
    override val winDeg: Int,
    override val weather: Array<Weather>,
    override val pop: Float,
    val temp : Float,
    val feelLike : Float,
    val visibility: Int
) : WeatherStatus(dt, sunrise,sunset,pressure,humidity,dewPoint,uvi,clouds,windSpeed,winDeg,weather,pop) {
}