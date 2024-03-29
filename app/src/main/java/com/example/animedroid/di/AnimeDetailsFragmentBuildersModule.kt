package com.example.animedroid.di

import com.example.animedroid.ui.fragments.AnimeDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AnimeDetailsFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun inject(): AnimeDetailsFragment
}