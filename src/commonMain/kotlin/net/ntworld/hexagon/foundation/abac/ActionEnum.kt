package net.ntworld.hexagon.foundation.abac

enum class ActionEnum(override val type: String) : Action {
    CREATE("CREATE"),
    READ("READ"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    VIEW("VIEW"),
    PROPOSE("PROPOSE"),
    EDIT("EDIT"),
    REQUEST("REQUEST"),
    APPROVE("APPROVE"),
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

fun actionView(): ActionEnum {
    return ActionEnum.VIEW
}

fun actionPropose(): ActionEnum {
    return ActionEnum.PROPOSE
}

fun actionEdit(): ActionEnum {
    return ActionEnum.EDIT
}

fun actionRequest(): ActionEnum {
    return ActionEnum.REQUEST
}

fun actionApprove(): ActionEnum {
    return ActionEnum.APPROVE
}