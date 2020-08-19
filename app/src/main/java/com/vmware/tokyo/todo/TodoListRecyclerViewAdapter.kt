package com.vmware.tokyo.todo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TodoListRecyclerViewAdapter(
    private val presenter: MainPresenter
) : RecyclerView.Adapter<TodoListRecyclerViewAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder)
    }

    override fun getItemCount(): Int = presenter.getTodoItemsCount()

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }

        fun setTitle(title: String) {
            contentView.text = title
        }
    }
}