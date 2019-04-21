package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.Action

internal enum class ActionEnum(override val type: String) : Action {
    CREATE("CREATE"),
    READ("READ"),
    UPDATE("UPDATE"),
    DELETE("DELETE")
}
