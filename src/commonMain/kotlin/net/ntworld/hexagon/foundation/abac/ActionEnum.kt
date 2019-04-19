package net.ntworld.hexagon.foundation.abac

enum class ActionEnum(override val type: String) : Action {
    CREATE("CREATE"),
    READ("READ"),
    UPDATE("UPDATE"),
    DELETE("DELETE")
}

fun actionCreate(): ActionEnum {
    return ActionEnum.CREATE
}

fun actionUpdate(): ActionEnum {
    return ActionEnum.UPDATE
}

fun actionDelete(): ActionEnum {
    return ActionEnum.DELETE
}

fun actionRead(): ActionEnum {
    return ActionEnum.READ
}
