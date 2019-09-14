package com.jeevan.byjus.di


import com.jeevan.byjus.ByjusApp
import com.jeevan.byjus.headlines.home.HeadlinesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class, DataModule::class])
interface ApplicationComponent {
    fun inject(byjusApp: ByjusApp)
    fun inject(byjusApp: HeadlinesActivity)
}