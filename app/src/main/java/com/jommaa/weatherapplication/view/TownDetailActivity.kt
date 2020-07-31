package com.jommaa.weatherapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jommaa.weatherapplication.R
import com.jommaa.weatherapplication.WeatherApplication
import com.jommaa.weatherapplication.databinding.ActivityDetailBinding
import com.jommaa.weatherapplication.viewmodel.DetailsViewModel
import com.jommaa.weatherapplication.viewmodel.TownsListViewModel
import javax.inject.Inject

class TownDetailActivity : BaseActivity() {

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_LAT = "lat"
        const val EXTRA_LONG = "long"

    }
    @Inject
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        (application as WeatherApplication).component.inject(this)
        binding.viewModel = viewModel

        viewModel.bound(intent.getStringExtra(EXTRA_NAME),intent.getDoubleExtra(EXTRA_LAT, 0.0),intent.getDoubleExtra(EXTRA_LONG, 0.0))
    }

}