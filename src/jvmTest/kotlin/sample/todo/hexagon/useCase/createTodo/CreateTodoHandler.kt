package sample.todo.hexagon.useCase.createTodo


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import net.ntworld.hexagon.foundation.HandlerAsync
import sample.todo.CreateTodoArgument
import sample.todo.Todo
import sample.todo.TodoRepository

internal class CreateTodoHandler(
    private val repository: TodoRepository
) : HandlerAsync<CreateTodoArgument, Todo> {

    override suspend fun handleAsync(args: CreateTodoArgument) = GlobalScope.async {
        val result = create(args.task)

        sample.todo.hexagon.data.Todo("1", result[0].task + ":" + result[1].task)
    }

    private suspend fun create(task: String): List<Todo> {
        return awaitAll(
            repository.createAsync(task),
            repository.createAsync(task)
        )
    }
}