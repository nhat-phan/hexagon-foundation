package net.ntworld.hexagon.foundation

interface Handler<in A: Argument, out Result> {
    fun handle(args: A): Result
}