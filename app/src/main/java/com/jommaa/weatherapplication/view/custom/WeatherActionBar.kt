package com.jommaa.weatherapplication.view.custom


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import com.jommaa.weatherapplication.R
import com.jommaa.weatherapplication.databinding.CustomActionBarBinding
import com.jommaa.weatherapplication.viewmodel.MainViewModel


class WeatherActionBar(context: Context,
                       attrs: AttributeSet? = null,
                       defStyle: Int = 0,
                       defStyleRes: Int = 0) : RelativeLayout(context, attrs, defStyle, defStyleRes) {

    var mBinding: CustomActionBarBinding? = null
    init {
       val Inflater= LayoutInflater.from(context)
        Inflater?.inflate(R.layout.custom_action_bar, this, true)
        mBinding  = DataBindingUtil.inflate(Inflater, R.layout.custom_action_bar, this, true)
    }

    fun setDataBinding(binding:MainViewModel){
        mBinding?.mainViewModel = binding
    }
}