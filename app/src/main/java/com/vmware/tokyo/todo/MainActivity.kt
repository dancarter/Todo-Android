package com.vmware.tokyo.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val todoRepository = NetworkTodoRepository(getTodoClient())

        mainPresenter = MainPresenter(this, todoRepository)

        mainPresenter.displayAllTodoItems()
    }

    override fun displayAllToDoItems(todos: List<Todo>?) {
        todoList.text = todos?.last()?.title ?: "Elvis"
    }
}
