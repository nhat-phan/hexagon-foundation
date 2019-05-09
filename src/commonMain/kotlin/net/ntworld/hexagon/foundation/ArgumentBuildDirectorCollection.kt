package net.ntworld.hexagon.foundation

class ArgumentBuildDirectorCollection<T : ArgumentBuilder>(base: ArgumentBuildDirector<T>) : ArgumentBuildDirector<T> {
    private val directors: MutableList<ArgumentBuildDirector<T>> = mutableListOf(base)

    override fun constructArgument(builder: T) {
        for (director in directors) {
            director.constructArgument(builder)
        }
    }

    fun add(buildDirector: ArgumentBuildDirector<T>) {
        directors.add(buildDirector)
    }

    operator fun plus(buildDirector: ArgumentBuildDirector<T>): ArgumentBuildDirector<T> {
        add(buildDirector)

        return this
    }
}