package com.jommaa.weatherapplication.viewmodel

import com.jommaa.datacomponent.Results.WeatherDetailsResult
import com.jommaa.datacomponent.WeatherApi
import com.jommaa.datacomponent.WeatherRepository.WeatherRepository
import com.jommaa.datacomponent.dataResponse.CurrentResponse
import com.jommaa.datacomponent.dataResponse.WeatherDetailsResponse
import com.jommaa.datacomponent.dataResponse.WeatherResponse
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.repositories.TownRepository
import com.jommaa.weatherapplication.rx.RxJavaTestHooksResetRule
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.BDDMockito.given
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TownDetailViewModelTest {

    @get:Rule
    var rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()

    @Mock
    lateinit var weatherRepository: WeatherRepository


    lateinit var sut: DetailsViewModel

    @Before
    fun setUp() {

        sut = DetailsViewModel(weatherRepository)
    }

    @Test
    fun `bound retrieves the town from lat and lng`(){
        val lat =12000.00
        val lng =12000.00
        val unit = "metric"
       given(weatherRepository.getWeatherDetails(lat,lng,unit)).willReturn(Observable.just(mock()))

        sut.bound("Paris",lat,lng)

        verify(weatherRepository).getWeatherDetails(eq(lat), eq(lng),eq(unit))
    }

    @Test
    fun `bound shows town details`() {
        val lat =12000.00
        val lng =12000.00
        val unit = "metric"
        val townName = "Paris"

        val pressure = 10
        val humidity = 20
        val temp=30f
        val visibility=60

        val current = CurrentResponse(
            dt = 12000,
         sunrise = 0,
        sunset =0,
         pressure=pressure,
         humidity=humidity,
         dewPoint=0f,
        uvi=0f,
         clouds=0,
         windSpeed=0f,
         winDeg=0,
         pop=0f,
         temp=temp,
         feelLike =0f,
         visibility=visibility,weatherResponse=null)


         val weatherDetails = WeatherDetailsResponse(0.0,0.0,"",0,current, null,null,null)

        given(weatherRepository.getWeatherDetails(lat,lng,unit)).willReturn(Observable.just(WeatherDetailsResult.Success(weatherDetails)))

        sut.bound(townName,lat,lng)
        /*
        Assert.assertThat(sut.pressure, CoreMatchers.equalTo("Pressure: "+pressure+" hPa"))
        Assert.assertThat(sut.humidity, CoreMatchers.equalTo("Humidity: "+humidity+" %"))
        Assert.assertThat(sut.temp, CoreMatchers.equalTo(temp.toString() +" C°"))
        Assert.assertThat(sut.visibility, CoreMatchers.equalTo("Visibility: "+visibility+" meters"))
       */

    }
}