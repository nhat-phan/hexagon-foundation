package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.Handler
import sample.todo.CreateTodoArgument
import sample.todo.Todo

internal class CreateTodoHandler: Handler<CreateTodoArgument, Todo> {
    override fun handle(args: CreateTodoArgument): Todo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}