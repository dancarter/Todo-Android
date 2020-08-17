package com.vmware.tokyo.todo

class SpyTodoRepository: TodoRepository {
    var getAll_wasCalled: Boolean = false
        private set
    var getAll_returnValue: List<Todo> = emptyList()

    override fun getAll(): List<Todo> {
        getAll_wasCalled = true
        return getAll_returnValue
    }
}
