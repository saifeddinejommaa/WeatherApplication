package com.jommaa.weatherapplication.viewmodel

import android.util.Log
import androidx.databinding.*
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.jommaa.datacomponent.Results.TownsListResult
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.repositories.TownRepository
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.view.AddNewTownActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val townRepository: TownRepository ) : ViewModel() {

    val disposables = CompositeDisposable()
    val progressVisible = ObservableBoolean()
    val townsList = ObservableArrayList<Town>()

    var townName = ObservableField<String>()
    private lateinit var  navigationHandler: INavigationHandler

    fun bound() {
        townsList.clear()
        townRepository.getAllTowns().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleGetAllTowns(it) }
            .addTo(disposables)
    }

    val onPageChangeListener : ViewPager.OnPageChangeListener = object :ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageSelected(position: Int) {
            townName.set(townsList.get(position).name)

        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int) {
        }
    }

    fun setNavigationHandler(navigationHandler: INavigationHandler){
        this.navigationHandler = navigationHandler
    }

    fun onAddTownButtonClick(){
        navigationHandler.showNextActivity(AddNewTownActivity::class.java,null)
    }

    fun onSettingsButtonClick(){

    }

    fun unbound() {
        disposables.clear()
    }

    private fun handleGetAllTowns(result: TownsListResult){

        when (result) {
            is TownsListResult.Success -> {
                townsList.addAll(result.list)
                townName.set(townsList.get(0).name)
            }
            is TownsListResult.Failure -> {
                Log.d("Info",result.toString())
            }
        }
    }

}