package net.ntworld.hexagon.foundation

interface Port<out B : ArgumentBuilder, out R> {
    fun reset(): Port<B, R>

    fun use(vararg directors: ArgumentBuildDirector<B>): Port<B, R>

    fun with(constructFn: (builder: B) -> Unit): Port<B, R>

    fun execute(): R
}