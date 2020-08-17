package com.vmware.tokyo.todo

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MainPresenterTest {
    @Test
    fun `displaying all items calls TodoRepository`() {
        val spyView = SpyView()
        val spyTodoRepository = SpyTodoRepository()
        val mainPresenter = MainPresenter(spyView, spyTodoRepository)


        mainPresenter.displayAllTodoItems()


        assertTrue(spyTodoRepository.getAll_wasCalled)
    }

    @Test
    fun `displaying all items tells the view to display to do items`() {
        val spyView = SpyView()
        val spyTodoRepository = SpyTodoRepository()
        val mainPresenter = MainPresenter(spyView, spyTodoRepository)

        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoRepository.getAll_returnValue = todos

        
        mainPresenter.displayAllTodoItems()


        assertEquals(spyView.displayAllToDoItems_argument_todos, todos)
    }
}