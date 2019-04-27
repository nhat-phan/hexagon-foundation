package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.UserArgumentFactoryBase
import net.ntworld.hexagon.foundation.UserArgumentData

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
