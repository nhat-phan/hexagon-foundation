package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.MultiTenancyArgumentFactoryBase

internal class CreateTodoArgumentFactory : MultiTenancyArgumentFactoryBase<CreateTodoArgument>() {
    override fun build(
        uniqueId: String,
        tenantId: String,
        context: ArgumentContext,
        data: ArgumentBuilderData
    ): CreateTodoArgument {
        return CreateTodoArgument(
            uniqueId, tenantId, context, data.getValue("task")
        )
    }

    override fun validate(data: ArgumentBuilderData): Boolean {
        data.isNotStringOrBlank("task") {
            errors.add("task", "required")
        }

        return errors.isEmpty()
    }

}
