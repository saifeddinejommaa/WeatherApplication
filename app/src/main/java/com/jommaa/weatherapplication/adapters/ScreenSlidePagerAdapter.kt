package com.jommaa.weatherapplication.adapters

import android.database.Observable
import android.view.View
import androidx.databinding.ObservableList
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.weatherapplication.view.fragment.WeatherDetailFragment
import com.jommaa.weatherapplication.viewmodel.MainViewModel

 class ScreenSlidePagerAdapter(val towns: ObservableList<Town>, fm:FragmentManager) : ObservableViewPagerAdapter<Town,Fragment>(towns,fm) {



     override fun getCount(): Int {
         return towns.count()
     }

     override fun getItem(position: Int): Fragment {

         return WeatherDetailFragment(towns[position])
     }


}