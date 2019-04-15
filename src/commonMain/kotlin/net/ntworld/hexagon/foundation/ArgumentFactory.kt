package net.ntworld.hexagon.foundation

interface ArgumentFactory<A : Argument> {
    fun make(): A
}