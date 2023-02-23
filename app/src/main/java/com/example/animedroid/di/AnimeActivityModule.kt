package com.example.animedroid.di

import com.example.animedroid.ui.AnimeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AnimeActivityModule {

    @ContributesAndroidInjector
    abstract fun inject(): AnimeActivity
}