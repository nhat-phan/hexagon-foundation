package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentFactory
import sample.todo.CreateTodoArgument
import sample.todo.CreateTodoArgumentBuilder

class CreateTodoArgumentBuilder : CreateTodoArgumentBuilder, ArgumentFactory<CreateTodoArgument> {
    internal val uniqueId: String = ""
    internal val contextEnvType: String = ""
    internal val contextEnvId: String = ""
    internal val contextDatetime: String = ""
    internal val task: String = ""

    override fun reset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUniqueId(value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setContextEnvironment(type: String, id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setContextDatetime(value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTask(task: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun make(): CreateTodoArgument {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}