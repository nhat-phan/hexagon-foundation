package net.ntworld.hexagon.foundation.abac

data class ActionImpl(override val type: String): Action

fun makeAction(type: String): Action {
    return ActionImpl(type)
}