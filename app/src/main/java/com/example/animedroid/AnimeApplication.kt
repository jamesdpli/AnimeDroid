package com.example.animedroid

import android.app.Application
import com.example.animedroid.di.DaggerAppComponent

// appComponent lives in the Application class to share its lifecycle
class AnimeApplication : Application() {

//  Reference to the application graph that is used across the whole app
    val appComponent = DaggerAppComponent.create()
}
