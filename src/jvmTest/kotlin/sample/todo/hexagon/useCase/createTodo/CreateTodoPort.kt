package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.*
import sample.todo.Todo
import sample.todo.TodoServiceProvider as ITodoServiceProvider
import sample.todo.CreateTodoArgument as ICreateTodoArgument
import sample.todo.CreateTodoArgumentBuilder as ICreateTodoArgumentBuilder

internal val CreateTodoPort =
    fun(spi: ITodoServiceProvider): PortAsync<ICreateTodoArgument, ICreateTodoArgumentBuilder, Todo> {
        val builder = CreateTodoArgumentBuilder()
        val factory = CreateTodoArgumentFactory()
        val handler = CreateTodoHandler(spi.todoRepository)

        return portOf(builder, factory, handler)
    }
