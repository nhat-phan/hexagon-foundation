package net.ntworld.hexagon.foundation

interface UserArgument: Argument {
    override val currentUserId: String
}