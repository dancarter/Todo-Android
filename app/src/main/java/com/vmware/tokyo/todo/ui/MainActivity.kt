package com.vmware.tokyo.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vmware.tokyo.todo.R

class MainActivity : AppCompatActivity(), MainContract.View {
    lateinit var mainPresenter: MainPresenter
    lateinit var todoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        todoRecyclerView = findViewById(R.id.todoList)
        mainPresenter.getAllTodoItems()
        todoRecyclerView.adapter = TodoListRecyclerViewAdapter(mainPresenter)
    }

    override fun updateTodoList() {
        todoRecyclerView.adapter?.notifyDataSetChanged()
    }
}
