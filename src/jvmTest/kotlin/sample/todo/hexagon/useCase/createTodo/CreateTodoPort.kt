package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.*
import sample.todo.Todo
import sample.todo.TodoServiceProvider
import sample.todo.hexagon.builder.TodoBuilder
import sample.todo.CreateTodoArgumentBuilder

internal val CreateTodoPort =
    fun(spi: TodoServiceProvider): PortAsync<CreateTodoArgumentBuilder, Todo> {
        val builder = TodoBuilder()
        val factory = CreateTodoArgumentFactory()

        return makePortAsync(builder, factory) {
            CreateTodoHandlerAsync(spi.todoRepository)
        }
    }
