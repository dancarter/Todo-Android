package com.vmware.tokyo.todo.components.todo

import com.vmware.tokyo.todo.ui.MainPresenter
import com.vmware.tokyo.todo.ui.SpyTodoViewHolder
import com.vmware.tokyo.todo.ui.SpyView
import com.vmware.tokyo.todo.utils.MainCoroutineScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@ExperimentalCoroutinesApi
class MainPresenterTest {
    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()
    private val spyTodoRepository = SpyTodoRepository()

    @Before
    fun setUp() {
        startKoin {
            modules(
                module {
                    single<TodoRepository> { spyTodoRepository }
                }
            )
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `getting all items calls TodoRepository to get items`() {
        val spyView = SpyView()
        val mainPresenter = MainPresenter(spyView)


        mainPresenter.getAllTodoItems()


        assertTrue(spyTodoRepository.getAll_wasCalled)
    }

    @Test
    fun `getting all items tells the view to update todo list`() {
        val spyView = SpyView()
        val mainPresenter = MainPresenter(spyView)

        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoRepository.getAll_returnValue = todos

        mainPresenter.getAllTodoItems()


        assertTrue(spyView.updateTodoList_wasCalled)
    }

    @Test
    fun `updateTodo updates each row with todo item`() {
        val spyView = SpyView()
        val spyTodoViewHolder = SpyTodoViewHolder()
        val mainPresenter = MainPresenter(spyView)

        val todos = listOf(
            Todo("Build Android TodoList app."),
            Todo("Set up iOS pipeline")
        )
        spyTodoRepository.getAll_returnValue = todos

        mainPresenter.getAllTodoItems()
        mainPresenter.updateTodoViewHolder(1, spyTodoViewHolder)


        assertEquals(spyTodoViewHolder.setTitle_title, todos[1].title)
    }

    @Test
    fun `getting size of todo list uses list returned by the repository`() {
        val spyView = SpyView()
        val mainPresenter = MainPresenter(spyView)
        val todos = listOf(Todo("Build Android TodoList app."))
        spyTodoRepository.getAll_returnValue = todos


        mainPresenter.getAllTodoItems()
        val todoItemsCount = mainPresenter.getTodoItemsCount()


        assertEquals(1, todoItemsCount)
    }
}
