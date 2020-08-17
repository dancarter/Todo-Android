package com.vmware.tokyo.todo

class MainContract {
    interface Presenter {
        fun displayAllTodoItems()
    }

    interface View {
        fun displayAllToDoItems(todos: List<Todo>)
    }
}
