package com.jommaa.weatherapplication.viewmodel

import com.jommaa.datacomponent.Results.TownsListResult
import com.jommaa.datacomponent.WeatherRepository.WeatherRepository
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.repositories.TownRepository
import com.jommaa.weatherapplication.rx.RxJavaTestHooksResetRule
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TownsListViewModelTest {

    @get:Rule
    var rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()

    @Mock
    lateinit var townRepository: TownRepository

    private lateinit var sut: TownsListViewModel

    @Before
    fun setUp() {
        sut = TownsListViewModel(townRepository)
    }

    @Test
    fun `bound retrieves the towns list`(){
        given(townRepository.getAllTowns())
            .willReturn(Observable.just(mock()))
        sut.bound()

        verify(townRepository).getAllTowns()
    }

    @Test
    fun `bound adds restaurants to list when successful`() {
        val towns = arrayListOf<Town>(mock(), mock())
        given(townRepository.getAllTowns())
            .willReturn(Observable.just(TownsListResult.Success(towns)))

        sut.bound()

        MatcherAssert.assertThat(sut.townsList.size, CoreMatchers.equalTo(2))
    }
}