package com.kit.koinarchitecture.di

import com.kit.koinarchitecture.utils.SharedPreferenceManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { SharedPreferenceManager(androidContext()) }
}