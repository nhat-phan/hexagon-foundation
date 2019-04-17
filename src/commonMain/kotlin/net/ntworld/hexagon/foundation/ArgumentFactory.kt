package net.ntworld.hexagon.foundation

interface ArgumentFactory<out A : Argument> {
    fun make(): A
}