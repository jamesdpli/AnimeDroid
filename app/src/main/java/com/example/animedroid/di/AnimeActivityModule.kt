package com.example.animedroid.di

import com.example.animedroid.AnimeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AnimeActivityModule {

    @ContributesAndroidInjector(
        modules = [
            AnimeListFragmentBuildersModule::class,
            AnimeDetailsFragmentBuildersModule::class
        ]
    )
    abstract fun inject(): AnimeActivity
}