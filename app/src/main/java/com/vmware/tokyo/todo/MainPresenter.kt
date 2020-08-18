package com.vmware.tokyo.todo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainPresenter(
    val todoView: MainContract.View,
    val todoRepository: TodoRepository
): MainContract.Presenter, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun displayAllTodoItems() {
        launch {
            val todos = todoRepository.getAll()
            todoView.displayAllToDoItems(todos)
        }
    }
}
