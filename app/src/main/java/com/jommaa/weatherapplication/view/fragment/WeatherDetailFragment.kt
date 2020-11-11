package com.jommaa.weatherapplication.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.weatherapplication.R
import com.jommaa.weatherapplication.WeatherApplication
import com.jommaa.weatherapplication.databinding.FragmentDetailBinding
import com.jommaa.weatherapplication.viewmodel.DetailsViewModel
import javax.inject.Inject

class WeatherDetailFragment(val town: Town): Fragment() {

    @Inject
    lateinit var viewModel: DetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false)
        val view = binding.root
        (activity?.application as WeatherApplication).component.inject(this)
        binding.viewModel = viewModel
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bound(town.name,town.lat,town.lon)

    }

}