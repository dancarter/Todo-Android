package com.vmware.tokyo.todo.components.todo

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val todoModule = module {
    single<TodoClient> { get<Retrofit>().create(TodoClient::class.java) }
    single<TodoRepository> { NetworkTodoRepository() }
}

val retrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(getProperty("serverBaseURL"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}