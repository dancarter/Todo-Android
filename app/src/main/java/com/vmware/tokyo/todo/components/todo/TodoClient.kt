package com.vmware.tokyo.todo.components.todo

import retrofit2.http.GET

interface TodoClient {
    @GET("/todos")
    suspend fun getAll(): List<Todo>
}
