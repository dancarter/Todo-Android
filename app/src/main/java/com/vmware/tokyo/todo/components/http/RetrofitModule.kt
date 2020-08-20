package com.vmware.tokyo.todo.components.http

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(getProperty("serverBaseURL"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}