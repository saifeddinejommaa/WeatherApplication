package com.jommaa.weatherapplication

import android.os.Bundle

interface INavigationHandler {

    fun showNextActivity(clazz: Class<*>, bundle: Bundle)

    fun finishActivity()
}