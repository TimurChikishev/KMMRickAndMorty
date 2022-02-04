package com.swallow.kmmrickandmorty.android.app

import android.app.Application
import com.swallow.kmmrickandmorty.android.di.androidNetworkModule
import com.swallow.kmmrickandmorty.android.di.appModule
import com.swallow.kmmrickandmorty.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            modules(
                appModule,
                androidNetworkModule
            )
        }

        Napier.base(DebugAntilog())
    }
}