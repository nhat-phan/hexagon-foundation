package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentContext
import sample.todo.CreateTodoArgument

internal data class CreateTodoArgument(
    override val uniqueId: String,
    override val tenantId: String,
    override val context: ArgumentContext,
    override val task: String
) : CreateTodoArgument