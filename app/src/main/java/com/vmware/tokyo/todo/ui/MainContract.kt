package com.vmware.tokyo.todo.ui

class MainContract {
    interface Presenter {
        fun getAllTodoItems()
    }

    interface View {
        fun updateTodoList()
    }
}
