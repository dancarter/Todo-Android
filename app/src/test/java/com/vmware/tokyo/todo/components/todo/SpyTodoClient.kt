package com.vmware.tokyo.todo.components.todo

class SpyTodoClient : TodoClient {
    var getAll_returnValue: List<Todo> = emptyList()

    override suspend fun getAll(): List<Todo> {
        return getAll_returnValue
    }
}