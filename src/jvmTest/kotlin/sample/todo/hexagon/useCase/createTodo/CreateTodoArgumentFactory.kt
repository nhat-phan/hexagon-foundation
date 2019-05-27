package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.*
import net.ntworld.hexagon.foundation.validation.assert
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentFactory : ArgumentFactory<CreateTodoArgumentBuilder, CreateTodoArgument> {
    override fun makeArgument(builder: CreateTodoArgumentBuilder): CreateTodoArgument {
        return builder
            .assert {
                builder::task always required
            }
            .makeUserArgument {
                CreateTodoArgument(
                    uniqueId = it.uniqueId,
                    currentUserId = it.currentUserId,
                    currentTenantId = it.currentTenantId,
                    context = it.context,
                    task = builder.task
                )
            }
    }
}
