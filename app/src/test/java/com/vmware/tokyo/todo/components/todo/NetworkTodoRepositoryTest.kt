package com.vmware.tokyo.todo.components.todo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@ExperimentalCoroutinesApi
class NetworkTodoRepositoryTest {
    private val spyTodoClient = SpyTodoClient()

    @Before
    fun setUp() {
        startKoin {
            modules(
                module {
                    single<TodoClient> { spyTodoClient }
                }
            )
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `getAll returns list of todos`() = runBlockingTest {
        val todoRepository = NetworkTodoRepository()

        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoClient.getAll_returnValue = todos


        val actual = todoRepository.getAll()


        assertEquals(todos, actual)
    }
}