package com.jommaa.datacomponent.WeatherObjects

import com.google.gson.annotations.SerializedName

data class WeatherDetails(

    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val current: Current,
    val minutely: Array<Minutely>,
    val hourly:Array<Current>,
    val daily: Array<Current>)

{

}