package com.swallow.kmmrickandmorty.android.app

import android.app.Application
import com.swallow.kmmrickandmorty.android.di.appModule
import com.swallow.kmmrickandmorty.android.di.repositoryModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                repositoryModule
            )
        }

        Napier.base(DebugAntilog())
    }
}