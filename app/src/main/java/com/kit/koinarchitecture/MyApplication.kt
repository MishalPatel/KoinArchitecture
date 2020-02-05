package com.kit.koinarchitecture

import android.app.Application
import com.kit.koinarchitecture.di.apiModule
import com.kit.koinarchitecture.di.appModule
import com.kit.koinarchitecture.di.networkModule
import com.kit.koinarchitecture.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(appModule, networkModule, apiModule, viewModelModule))
        }

    }
}