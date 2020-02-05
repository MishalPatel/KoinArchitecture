package com.kit.koinarchitecture.di

import com.kit.koinarchitecture.data.rest.RepoService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(RepoService::class.java) }
}