package com.vmware.tokyo.todo

interface TodoRepository {
    fun getAll(): List<Todo>
}
