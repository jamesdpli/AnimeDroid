package com.example.animedroid.di

import com.example.animedroid.ui.AnimeApplication
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        AnimeActivityModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(animeApplication: AnimeApplication): AnimeApplication
}