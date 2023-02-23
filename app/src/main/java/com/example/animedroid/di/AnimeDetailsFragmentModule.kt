package com.example.animedroid.di

import com.example.animedroid.ui.views.AnimeDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AnimeDetailsFragmentModule {

    @ContributesAndroidInjector
    abstract fun inject(): AnimeDetailsFragment
}