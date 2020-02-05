package com.kit.koinarchitecture.di

import com.kit.koinarchitecture.views.ListPostViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListPostViewModel(get()) }
}