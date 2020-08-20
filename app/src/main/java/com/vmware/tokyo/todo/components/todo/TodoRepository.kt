package com.vmware.tokyo.todo.components.todo

import org.koin.java.KoinJavaComponent.inject

interface TodoRepository {
    suspend fun getAll(): List<Todo>
}

class NetworkTodoRepository : TodoRepository {
    private val todoClient: TodoClient by inject(TodoClient::class.java)

    override suspend fun getAll(): List<Todo> {
        return todoClient.getAll()
    }
}