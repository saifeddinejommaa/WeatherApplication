package com.jommaa.weatherapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jommaa.weatherapplication.INavigationHandler

open abstract class BaseActivity : AppCompatActivity() , INavigationHandler {

    override fun showNextActivity(clazz: Class<*>, bundle: Bundle) {
        startActivity(Intent(this,clazz).putExtras(bundle))
    }

    override fun finishActivity() {
        finish()
    }
}