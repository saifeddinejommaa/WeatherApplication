package com.jommaa.weatherapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.R
import com.jommaa.weatherapplication.WeatherApplication
import com.jommaa.weatherapplication.databinding.ActivityNewTownBinding
import com.jommaa.weatherapplication.viewmodel.AddNewTownViewModel
import javax.inject.Inject

class AddNewTownActivity  : BaseActivity() {

    @Inject
    lateinit var viewModel: AddNewTownViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewTownBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_new_town
        )
        (application as WeatherApplication).component.inject(this)

        binding.viewModel = viewModel
        viewModel.setNavigationHandler((this))
    }


}