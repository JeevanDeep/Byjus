package com.jeevan.byjus.di

import android.content.Context
import androidx.room.Room
import com.jeevan.byjus.db.AppDatabase
import com.jeevan.byjus.db.HeadlineDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): AppDatabase {
        val builder = Room.databaseBuilder(context, AppDatabase::class.java, "headlines_db")
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesHeadlinesDao(appDatabase: AppDatabase): HeadlineDao = appDatabase.getHeadlinesDao()
}