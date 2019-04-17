package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.*
import sample.todo.Todo
import sample.todo.CreateTodoArgument as ICreateTodoArgument
import sample.todo.CreateTodoArgumentBuilder as ICreateTodoArgumentBuilder

//
//class BasicPortImpl<in A : Argument, out R>(
//    private val factory: ArgumentFactory<A>,
//    private val handler: Handler<A, R>
//) : BasicPort<A, R> {
//    private var argument: A? = null
//
//    override fun execute(): R {
//        return handler.handle(this.argument ?: factory.make())
//    }
//
//    override fun with(argument: A): ExecutablePort<R> {
//        this.argument = argument
//
//        return this
//    }
//}


//fun <A : Argument, R> portOf(
//    factory: ArgumentFactory<A>,
//    handler: Handler<A, R>
//): BasicPort<A, R> {
//    return BasicPortImpl(factory, handler)
//}

class Log<in A : Argument, out R>(handler: Handler<A, R>) : HandlerDecorator<A, R>(handler) {

}

internal fun makeCreateTodoPort(): Port<ICreateTodoArgument, ICreateTodoArgumentBuilder, Todo> {
    val builder = CreateTodoArgumentBuilder()
    val handler = Log(CreateTodoHandler())

    return portOf(builder, handler)
}
