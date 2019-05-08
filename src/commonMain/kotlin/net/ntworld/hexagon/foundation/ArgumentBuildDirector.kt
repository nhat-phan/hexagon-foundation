package net.ntworld.hexagon.foundation

interface ArgumentBuildDirector<in T : ArgumentBuilder> {
    fun constructArgument(builder: T)
}

