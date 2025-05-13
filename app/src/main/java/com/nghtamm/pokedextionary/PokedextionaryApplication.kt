package com.nghtamm.pokedextionary

import android.app.Application
import com.nghtamm.pokedextionary.core.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedextionaryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedextionaryApplication)
            modules(applicationModule)
        }
    }
}
