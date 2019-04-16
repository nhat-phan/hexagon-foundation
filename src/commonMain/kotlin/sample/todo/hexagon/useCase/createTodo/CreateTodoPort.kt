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

class PortImpl<in A : Argument, out B : ArgumentBuilder, out R>(
    private val builder: B,
    private val factory: ArgumentFactory<A>,
    private val handler: Handler<A, R>
): Port<A, B, R> {
    override fun execute(): R {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun use(director: ArgumentDirector<B>): Port<A, B, R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun with(constructFn: (builder: B) -> Unit): Port<A, B, R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun with(argument: A): Port<A, B, R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

//fun <A : Argument, R> portOf(
//    factory: ArgumentFactory<A>,
//    handler: Handler<A, R>
//): BasicPort<A, R> {
//    return BasicPortImpl(factory, handler)
//}

fun <A : Argument, B: ArgumentBuilder, R> portOf(
    factory: ArgumentFactory<A>,
    builder: B,
    handler: Handler<A, R>
): Port<A, B, R> {
    return PortImpl(builder, factory, handler)
}

internal fun makeCreateTodoPort(): Port<ICreateTodoArgument, ICreateTodoArgumentBuilder, Todo> {
    val builder = CreateTodoArgumentBuilder()
    return portOf(
        builder,
        builder,
        CreateTodoHandler()
    )
}
