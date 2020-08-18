package com.vmware.tokyo.todo

class SpyView : MainContract.View {
    var displayAllToDoItems_argument_todos: List<Todo>? = null

    override fun displayAllToDoItems(todos: List<Todo>?) {
        displayAllToDoItems_argument_todos = todos
    }
}
