package com.jommaa.weatherapplication.viewmodel

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.jommaa.datacomponent.Results.TownsListResult
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.repositories.TownRepository
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.view.AddNewTownActivity
import com.jommaa.weatherapplication.view.TownDetailActivity
import com.jommaa.weatherapplication.view.fragment.WeatherDetailFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val townRepository: TownRepository ) : ViewModel() {

    val disposables = CompositeDisposable()
    val progressVisible = ObservableBoolean()
    val townsList = ObservableArrayList<Town>()
    var townName:String? = null
    private lateinit var  navigationHandler: INavigationHandler

    // val fragmentsList = ObservableArrayList<WeatherDetailFragment>()

    // Called onCreate. Retrieves the list of restaurants
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
            townName = townsList.get(position).name
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int) {
            townName = townsList.get(position).name
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

    // Called onDestroy. Clean up method.
    fun unbound() {
        disposables.clear()
    }


    private fun handleGetAllTowns(result: TownsListResult){

        when (result) {
            is TownsListResult.Success -> {
                townsList.addAll(result.list)
            }
            is TownsListResult.Failure -> {
                Log.d("Info",result.toString())
            }
        }
    }




    /*
    // Shows restaurant detail screen based on restaurant clicked
    fun onTownClicked(town: Any) {

          (town as Town)?.let {
              putString(TownDetailActivity.EXTRA_NAME,it.name)
              putDouble(TownDetailActivity.EXTRA_LAT, it.lat)
              putDouble(TownDetailActivity.EXTRA_LONG, it.lon)
          } })
    }

     */



}