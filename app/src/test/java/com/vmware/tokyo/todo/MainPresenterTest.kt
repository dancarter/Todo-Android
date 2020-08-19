package com.vmware.tokyo.todo

import com.vmware.tokyo.todo.utils.MainCoroutineScopeRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class MainPresenterTest {
    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    @Test
    fun `getting all items calls TodoRepository to get items`() {
        val spyView = SpyView()
        val spyTodoRepository = SpyTodoRepository()
        val mainPresenter = MainPresenter(spyView, spyTodoRepository)


        mainPresenter.getAllTodoItems()


        assertTrue(spyTodoRepository.getAll_wasCalled)
    }

    @Test
    fun `getting all items tells the view to update todo list`() {
        val spyView = SpyView()
        val spyTodoRepository = SpyTodoRepository()
        val mainPresenter = MainPresenter(spyView, spyTodoRepository)

        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoRepository.getAll_returnValue = todos

        mainPresenter.getAllTodoItems()


        assertTrue(spyView.updateTodoList_wasCalled)
    }

    @Test
    fun `getting size of todo list uses list returned by the repository`() {
        val spyView = SpyView()
        val spyTodoRepository = SpyTodoRepository()
        val mainPresenter = MainPresenter(spyView, spyTodoRepository)

        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoRepository.getAll_returnValue = todos

        mainPresenter.getAllTodoItems()
        val todoItemsCount = mainPresenter.getTodoItemsCount()


        assertEquals(1, todoItemsCount)
    }

    @Test
    fun `updateTodo updates each row with todo item`() {
        val spyView = SpyView()
        val spyTodoRepository = SpyTodoRepository()
        val spyTodoViewHolder = SpyTodoViewHolder()
        val mainPresenter = MainPresenter(spyView, spyTodoRepository)

        val todos = listOf(
            Todo("Build Android TodoList app."),
            Todo("Set up iOS pipeline")
        )
        spyTodoRepository.getAll_returnValue = todos

        mainPresenter.getAllTodoItems()
        mainPresenter.updateTodo(1, spyTodoViewHolder)


        assertEquals(spyTodoViewHolder.setTitle_title, todos[1].title)
    }
}
