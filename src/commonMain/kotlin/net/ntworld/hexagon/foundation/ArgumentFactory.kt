package net.ntworld.hexagon.foundation

interface ArgumentFactory<in B : ArgumentBuilder, out A : Argument> {
    fun makeArgument(builder: B): A
}