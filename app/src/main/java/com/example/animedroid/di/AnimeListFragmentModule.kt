package com.example.animedroid.di

import com.example.animedroid.ui.views.AnimeListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AnimeListFragmentModule {

    @ContributesAndroidInjector
    abstract fun inject(): AnimeListFragment
}