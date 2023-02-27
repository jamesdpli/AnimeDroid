package com.example.animedroid.di

import com.example.animedroid.ui.AnimeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        AnimeActivityModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<AnimeApplication> {
    override fun inject(animeApplication: AnimeApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AnimeApplication): Builder

        fun build(): AppComponent
    }
}