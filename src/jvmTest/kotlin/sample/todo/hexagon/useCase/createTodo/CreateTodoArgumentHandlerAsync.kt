package sample.todo.hexagon.useCase.createTodo


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import net.ntworld.hexagon.foundation.ArgumentHandlerAsync
import sample.todo.Todo
import sample.todo.TodoRepository

internal class CreateTodoArgumentHandlerAsync(
    private val repository: TodoRepository
) : ArgumentHandlerAsync<CreateTodoArgument, Todo> {

    override fun handleAsync(argument: CreateTodoArgument) = GlobalScope.async {
        val result = create(argument.task)

        sample.todo.hexagon.entity.Todo("1", result[0].task + ":" + result[1].task)
    }

    private suspend fun create(task: String): List<Todo> {
        return awaitAll(
            repository.createAsync(task),
            repository.createAsync(task)
        )
    }
}