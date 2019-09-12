package com.jeevan.byjus.di



import com.jeevan.byjus.ByjusApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(byjusApp: ByjusApp)
}