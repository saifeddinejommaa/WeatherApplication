package com.jommaa.weatherapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jommaa.weatherapplication.INavigationHandler
import com.jommaa.weatherapplication.WeatherApplication


open abstract class BaseActivity : AppCompatActivity() , INavigationHandler {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as WeatherApplication).component.inject(this)

    }

    override fun showNextActivity(clazz: Class<*>, bundle: Bundle?) {
        if(bundle!=null){
            startActivity(Intent(this,clazz).putExtras(bundle))
        }
        else{
            startActivity(Intent(this,clazz))
        }

    }

    override fun finishActivity() {
        finish()
    }


}