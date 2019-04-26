package sample.todo

import kotlinx.coroutines.Deferred

interface TodoRepository {
    fun createAsync(task: String): Deferred<Todo>
}

interface TodoServiceProvider {
    val todoRepository: TodoRepository
}