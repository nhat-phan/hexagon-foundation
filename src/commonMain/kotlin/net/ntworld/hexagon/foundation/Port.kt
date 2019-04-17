package net.ntworld.hexagon.foundation

interface Port<in A : Argument, out B : ArgumentBuilder, out R> {
    fun reset(): Port<A, B, R>

    fun use(vararg directors: ArgumentDirector<B>): Port<A, B, R>

    fun with(constructFn: (builder: B) -> Unit): Port<A, B, R>

    fun with(argument: A): Port<A, B, R>

    fun execute(): R
}