package com.jommaa.datacomponent.WeatherObjects

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    val oneOur: Float) {
}