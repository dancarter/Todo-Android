package com.vmware.tokyo.todo.ui

import com.vmware.tokyo.todo.components.todo.Todo
import com.vmware.tokyo.todo.components.todo.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import kotlin.coroutines.CoroutineContext

class MainPresenter(
    val todoView: MainContract.View
) : MainContract.Presenter, CoroutineScope {
    private var todoList: List<Todo> = emptyList()
    private val todoRepository: TodoRepository by inject(TodoRepository::class.java)
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Main

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
