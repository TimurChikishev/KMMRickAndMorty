package com.swallow.kmmrickandmorty.android.di

import okhttp3.OkHttpClient
import org.koin.dsl.module

val androidNetworkModule = module {
    single {
        OkHttpClient.Builder().build()
    }
}