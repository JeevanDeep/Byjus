package com.jeevan.byjus.di

import android.app.Application
import android.content.Context
import com.jeevan.byjus.ByjusApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var byjusApp: ByjusApp) {

    @Provides
    @Singleton
    fun provideApp(): Application {
        return byjusApp
    }

    @Provides
    @Singleton
    fun getContext(): Context = byjusApp

}