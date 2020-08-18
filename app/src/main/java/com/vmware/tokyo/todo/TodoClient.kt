package com.vmware.tokyo.todo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TodoClient {
    @GET("/todos")
    suspend fun getAll(): List<Todo>
}

private val client: TodoClient by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://todolistserver.cfapps.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(TodoClient::class.java)
}

fun getTodoClient() = client
