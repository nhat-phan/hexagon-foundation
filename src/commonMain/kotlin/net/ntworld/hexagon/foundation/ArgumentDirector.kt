package net.ntworld.hexagon.foundation

interface ArgumentDirector<in T: ArgumentBuilder> {
    fun constructArgument(builder: T)
}