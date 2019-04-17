package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.*
import sample.todo.Todo
import sample.todo.TodoServiceProvider as ITodoServiceProvider
import sample.todo.CreateTodoArgument as ICreateTodoArgument
import sample.todo.CreateTodoArgumentBuilder as ICreateTodoArgumentBuilder

class Log<in A : Argument, out R>(handler: Handler<A, R>) : HandlerDecorator<A, R>(handler) {

}

internal val CreateTodoPort =
    fun(spi: ITodoServiceProvider): Port<ICreateTodoArgument, ICreateTodoArgumentBuilder, Todo> {
        val builder = CreateTodoArgumentBuilder()
        val handler = Log(CreateTodoHandler())

        return portOf(builder, handler)
    }
