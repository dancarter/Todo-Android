package com.vmware.tokyo.todo.ui

class SpyView : MainContract.View {
    var updateTodoList_wasCalled = false

    override fun updateTodoList() {
        updateTodoList_wasCalled = true
    }
}
