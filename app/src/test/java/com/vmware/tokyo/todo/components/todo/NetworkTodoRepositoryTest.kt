package com.vmware.tokyo.todo.components.todo

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkTodoRepositoryTest {
    @Test
    fun `getAll returns list of todos`() = runBlockingTest {
        val spyTodoClient = SpyTodoClient()
        val todoRepository = NetworkTodoRepository(spyTodoClient)

        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoClient.getAll_returnValue = todos


        val actual = todoRepository.getAll()


        assertEquals(todos, actual)
    }
}