package net.ntworld.hexagon.foundation

interface Port<out Builder : ArgumentBuilder, out Result> {
    infix fun use(director: ArgumentBuildDirector<Builder>): Port<Builder, Result>

    infix fun with(block: Builder.() -> Unit): Result
}