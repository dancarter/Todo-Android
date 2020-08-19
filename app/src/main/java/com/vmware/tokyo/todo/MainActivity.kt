package com.vmware.tokyo.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

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
