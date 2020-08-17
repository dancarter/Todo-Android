package com.vmware.tokyo.todo

class MainPresenter(
    val todoView: MainContract.View,
    val todoRepository: TodoRepository
): MainContract.Presenter {
    override fun displayAllTodoItems() {
        todoView.displayAllToDoItems(todoRepository.getAll())
    }
}
