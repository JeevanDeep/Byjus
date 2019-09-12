package com.jeevan.byjus

import android.app.Application
import com.jeevan.byjus.di.ApplicationComponent
import com.jeevan.byjus.di.ApplicationModule
import com.jeevan.byjus.di.DaggerApplicationComponent

class ByjusApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        setupDagger()
    }

    private fun setupDagger() {
        applicationComponent =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
    }

    companion object {
        lateinit var instance: ByjusApp
            private set
        lateinit var applicationComponent: ApplicationComponent
            private set
    }
}