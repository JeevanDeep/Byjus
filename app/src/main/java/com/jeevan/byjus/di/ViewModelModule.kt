package com.jeevan.byjus.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeevan.byjus.headlines.HeadlinesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HeadlinesViewModel::class)
    abstract fun provideHeadlinesViewModel(headlinesViewModel: HeadlinesViewModel): ViewModel
}

