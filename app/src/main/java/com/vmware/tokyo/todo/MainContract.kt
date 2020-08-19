package com.vmware.tokyo.todo

class MainContract {
    interface Presenter {
        fun getAllTodoItems()
    }

    interface View {
        fun updateTodoList()
    }
}
