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

    override fun handleAsync(args: CreateTodoArgument) = GlobalScope.async {
//        val first = repository.createAsync(args.task).await()
//        val second = repository.createAsync(args.task).await()
//
//        sample.todo.hexagon.data.Todo("1", first.task + ":" + second.task)

        val result = awaitAll(
            repository.createAsync(args.task),
            repository.createAsync(args.task)
        )
        sample.todo.hexagon.data.Todo("1", result[0].task + ":" + result[1].task)

        // sample.todo.hexagon.data.Todo("1", first.task + ":" + second.task)
    }

}