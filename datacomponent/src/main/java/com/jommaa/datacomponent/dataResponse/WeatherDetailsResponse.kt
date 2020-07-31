package com.jommaa.datacomponent.dataResponse

import com.google.gson.annotations.SerializedName

data class WeatherDetailsResponse(

    val lat: Double,
    val lon: Double,
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int,
    val current: CurrentResponse,
    val minutely: Array<MinutelyResponse>?,
    val hourly:Array<CurrentResponse>?,
    val daily: Array<CurrentResponse>?)

{

}