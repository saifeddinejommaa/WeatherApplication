package com.jommaa.weatherapplication.adapters

import androidx.databinding.ObservableList
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.weatherapplication.view.fragment.WeatherDetailFragment

 class ScreenSlidePagerAdapter(val towns: ObservableList<Town>, fm:FragmentManager) : ObservableViewPagerAdapter<Town,Fragment>(towns,fm) {



     override fun getCount(): Int {
         return towns.count()
     }

     override fun getItem(position: Int): Fragment {

         return WeatherDetailFragment(towns[position])
     }


}