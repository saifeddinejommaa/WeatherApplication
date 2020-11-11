package com.jommaa.weatherapplication.oberver

import java.util.*

class FragmentObserver : Observable() {

    override fun notifyObservers() {
        setChanged()
        super.notifyObservers()
    }
}