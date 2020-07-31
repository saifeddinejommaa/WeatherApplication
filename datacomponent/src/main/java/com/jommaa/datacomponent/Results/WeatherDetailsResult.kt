package com.jommaa.datacomponent.Results
import com.jommaa.datacomponent.dataResponse.WeatherDetailsResponse

sealed class WeatherDetailsResult {
    object Loading : WeatherDetailsResult()
    data class Success(val details: WeatherDetailsResponse) : WeatherDetailsResult()
    data class Failure(val throwable: Throwable) : WeatherDetailsResult()
}