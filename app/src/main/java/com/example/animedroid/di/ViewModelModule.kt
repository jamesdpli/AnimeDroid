package com.example.animedroid.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animedroid.ui.viewmodels.AnimeDetailFragmentViewModel
import com.example.animedroid.ui.viewmodels.AnimeListFragmentViewModel
import com.example.animedroid.ui.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AnimeListFragmentViewModel::class)
    internal abstract fun animeListFragmentViewModel(viewModel: AnimeListFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnimeDetailFragmentViewModel::class)
    internal abstract fun animeDetailsFragmentViewModel(viewModel: AnimeDetailFragmentViewModel): ViewModel
}