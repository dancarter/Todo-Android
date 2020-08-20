package com.vmware.tokyo.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vmware.tokyo.todo.*
import com.vmware.tokyo.todo.components.todo.NetworkTodoRepository
import com.vmware.tokyo.todo.components.todo.getTodoClient

class MainActivity : AppCompatActivity(), MainContract.View {
    lateinit var mainPresenter: MainPresenter
    lateinit var todoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val todoRepository = NetworkTodoRepository(getTodoClient())
        mainPresenter = MainPresenter(this, todoRepository)
        todoRecyclerView = findViewById(R.id.todoList)
        mainPresenter.getAllTodoItems()
        todoRecyclerView.adapter = TodoListRecyclerViewAdapter(mainPresenter)
    }

    override fun updateTodoList() {
        todoRecyclerView.adapter?.notifyDataSetChanged()
    }
}
