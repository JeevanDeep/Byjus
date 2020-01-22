package com.jeevan.byjus.di

import android.app.Application
import android.content.Context
import com.jeevan.byjus.ByjusApp
import com.jeevan.byjus.headlines.HeadlinesRepo
import com.jeevan.byjus.headlines.home.HeadlinesDataSource
import dagger.Binds
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