package com.ferdialif.pokemonapps

import android.app.Application
import com.ferdialif.pokemonapps.core.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(mainModule)
        }
    }
}