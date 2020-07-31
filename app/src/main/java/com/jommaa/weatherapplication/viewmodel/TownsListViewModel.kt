package com.jommaa.weatherapplication.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.jommaa.datacomponent.Results.TownsListResult
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.repositories.TownRepository
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.view.TownDetailActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TownsListViewModel @Inject constructor(val townRepository: TownRepository ) : ViewModel() {

    val disposables = CompositeDisposable()
    val progressVisible = ObservableBoolean()
    val townsList = ObservableArrayList<Town>()
    private lateinit var  navigationHandler: INavigationHandler
    // Called onCreate. Retrieves the list of restaurants
    fun bound() {
        townsList.clear()
        townRepository.getAllTowns().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleGetAllTowns(it) }
            .addTo(disposables)
    }

    fun setNavigationHandler(navigationHandler: INavigationHandler){
        this.navigationHandler = navigationHandler
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

    // Shows restaurant detail screen based on restaurant clicked
    fun onTownClicked(town: Any) {
      navigationHandler.showNextActivity(TownDetailActivity::class.java,Bundle().apply {

          (town as Town)?.let {
              putString(TownDetailActivity.EXTRA_NAME,it.name)
              putDouble(TownDetailActivity.EXTRA_LAT, it.lat)
              putDouble(TownDetailActivity.EXTRA_LONG, it.lon)
          } })
    }

}