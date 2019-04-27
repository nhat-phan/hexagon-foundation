package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.UserArgument

internal data class CreateTodoArgument(
    override val uniqueId: String,
    override val currentUserId: String,
    override val currentTenantId: String?,
    override val context: ArgumentContext,
    val task: String
) : UserArgument