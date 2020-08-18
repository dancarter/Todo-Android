package com.vmware.tokyo.todo

interface TodoRepository {
    suspend fun getAll(): List<Todo>
}

class NetworkTodoRepository(val todoClient: TodoClient): TodoRepository {
    override suspend fun getAll(): List<Todo> {
        return todoClient.getAll()
    }
}