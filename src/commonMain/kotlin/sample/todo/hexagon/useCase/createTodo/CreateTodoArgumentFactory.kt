package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.ArgumentFactoryBase

internal class CreateTodoArgumentFactory : ArgumentFactoryBase<CreateTodoArgument>() {
    override fun build(
        uniqueId: String,
        context: ArgumentContext,
        data: ArgumentBuilderData
    ): CreateTodoArgument {
        return CreateTodoArgument(
            uniqueId, context, data.getValue("task")
        )
    }

    override fun validate(data: ArgumentBuilderData): Boolean {
        data.isNotStringOrBlank("task") {
            errors.add("task", "required")
        }

        return errors.isEmpty()
    }

}
