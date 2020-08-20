package com.vmware.tokyo.todo.components.todo

import org.koin.dsl.module
import retrofit2.Retrofit

val todoModule = module {
    single<TodoClient> { get<Retrofit>().create(TodoClient::class.java) }
    single<TodoRepository> { NetworkTodoRepository() }
}
