package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.*
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentFactory : UserArgumentFactoryBase<CreateTodoArgument>() {
    override fun make(data: UserArgumentData): CreateTodoArgument {
        return CreateTodoArgument(
            uniqueId = data.uniqueId,
            currentUserId = data.currentUserId,
            currentTenantId = data.currentTenantId,
            context = data.context,
            task = data.getValue("task")
        )
    }

    override fun validate(data: UserArgumentData, errors: MessageBag): Boolean {
        data.isNotStringOrBlank("task") {
            errors.add("task", "required")
        }

        return errors.isEmpty()
    }

}
