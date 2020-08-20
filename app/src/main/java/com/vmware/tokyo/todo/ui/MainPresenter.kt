package com.vmware.tokyo.todo.ui

import com.vmware.tokyo.todo.components.todo.Todo
import com.vmware.tokyo.todo.components.todo.TodoRepository
import com.vmware.tokyo.todo.ui.MainContract
import com.vmware.tokyo.todo.ui.TodoItemViewHolder
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainPresenter(
    val todoView: MainContract.View,
    val todoRepository: TodoRepository
) : MainContract.Presenter, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main
    private var todoList: List<Todo> = emptyList()

    override fun getAllTodoItems() {
        launch {
            todoList = todoRepository.getAll()
            todoView.updateTodoList()
        }
    }

    fun updateTodoViewHolder(
        position: Int,
        holder: TodoItemViewHolder
    ) {
        val item = todoList[position]
        holder.setTitle(item.title)
    }

    fun getTodoItemsCount(): Int {
        return todoList.size
    }
}