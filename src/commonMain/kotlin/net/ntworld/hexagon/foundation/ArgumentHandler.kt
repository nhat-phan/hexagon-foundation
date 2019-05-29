package net.ntworld.hexagon.foundation

interface ArgumentHandler<in A : Argument, out Result> {
    fun handle(argument: A): Result
}