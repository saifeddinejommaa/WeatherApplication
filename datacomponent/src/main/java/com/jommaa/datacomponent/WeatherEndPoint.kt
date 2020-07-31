package com.jommaa.datacomponent

import com.jommaa.datacomponent.dataResponse.WeatherDetailsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherEndPoint {
    @GET("onecall")
    fun getWeatherDetails(@Query("lat") lat: Double, @Query("lon") lng: Double,@Query("exclude")exclude:String, @Query("appid")appKey: String,@Query("units") units: String): Single<WeatherDetailsResponse>

}