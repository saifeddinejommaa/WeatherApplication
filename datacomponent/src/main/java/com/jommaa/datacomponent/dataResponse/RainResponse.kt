package com.jommaa.datacomponent.dataResponse

import com.google.gson.annotations.SerializedName

data class RainResponse(
    @SerializedName("1h")
    val oneOur: Float) {
}