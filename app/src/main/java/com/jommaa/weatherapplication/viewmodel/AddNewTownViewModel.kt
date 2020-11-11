package com.jommaa.weatherapplication.viewmodel


import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.repositories.TownRepository
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.WeatherApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.StringBuilder
import java.util.*
import javax.inject.Inject

class AddNewTownViewModel @Inject constructor(val townRepository: TownRepository,val application: WeatherApplication) : ViewModel() {

    var townName: String = ""
    var result= ObservableField<String>()
    var newTown: Town? = null
    var isAddTownButtonVisible : Boolean = false
    private lateinit var  navigationHandler: INavigationHandler

    fun setNavigationHandler(navigationHandler: INavigationHandler){
        this.navigationHandler = navigationHandler
    }

   fun onFindButtonclick(view:View){
       if(townName.equals("")){
           Toast.makeText(application,"Please enter a valid town Name",Toast.LENGTH_LONG).show()
           return
       }

       val geocoder = Geocoder(application,Locale.getDefault())
       val addressList: MutableList<Address>? =geocoder.getFromLocationName(townName,1)
       addressList?.let {
           if(addressList?.count()?.compareTo(0)!=0){
               result.set(StringBuilder().append("Latitude: ").
               append(addressList[0].latitude)
                   .append("  longitude: ")
                   .append(addressList[0].longitude).toString())
               newTown=Town(townName,addressList[0].latitude,addressList[0].longitude)
               isAddTownButtonVisible = true
           }

       }

   }

    fun onAddNewTown(view:View){
        isAddTownButtonVisible = false
        newTown?.let {
            townRepository.insertTown(newTown).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe{{
                    Log.d("test", "Blog Db: list insertion was successful")
                }; {
                    Log.d("test", "no data" )

                }}

        }
        navigationHandler.finishActivity()

    }

}