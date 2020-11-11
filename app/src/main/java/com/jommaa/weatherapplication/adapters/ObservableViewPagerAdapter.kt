package com.jommaa.weatherapplication.adapters

import androidx.databinding.ObservableList
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class ObservableViewPagerAdapter<T,Fragment>(items: ObservableList<T>, fm : FragmentManager) : FragmentPagerAdapter(fm) {

    init {
        items.addOnListChangedCallback(object: ObservableList.OnListChangedCallback<ObservableList<T>>() {
            override fun onChanged(sender: ObservableList<T>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyDataSetChanged()
            }

            override fun onItemRangeMoved(sender: ObservableList<T>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                notifyDataSetChanged()
            }

            override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
                notifyDataSetChanged()
            }
        })
    }

}