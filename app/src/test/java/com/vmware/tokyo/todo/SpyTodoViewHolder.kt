package com.vmware.tokyo.todo

class SpyTodoViewHolder: TodoItemViewHolder {
    var setTitle_title = ""

    override fun setTitle(title: String) {
        setTitle_title = title
    }
}
