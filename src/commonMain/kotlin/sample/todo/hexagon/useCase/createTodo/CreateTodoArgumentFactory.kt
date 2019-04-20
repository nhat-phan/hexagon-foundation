package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.MultiTenancyArgumentFactoryBase

internal class CreateTodoArgumentFactory :
    MultiTenancyArgumentFactoryBase<CreateTodoArgumentBuilder, CreateTodoArgument>() {

    override fun build(
        uniqueId: String,
        tenantId: String,
        context: ArgumentContext,
        builder: CreateTodoArgumentBuilder
    ): CreateTodoArgument {
        return CreateTodoArgument(uniqueId, tenantId, context, builder.task)
    }

    override fun validate(builder: CreateTodoArgumentBuilder): Boolean {
        return true
    }

}