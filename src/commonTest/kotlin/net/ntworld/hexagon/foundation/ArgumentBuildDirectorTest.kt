package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.builder.LinkedHashMapBuilderStorage
import net.ntworld.hexagon.foundation.builder.string
import kotlin.test.Test
import kotlin.test.assertEquals

class Jwt : ArgumentBuildDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {
        builder.uniqueId = "jwt"
    }
}

class Session : ArgumentBuildDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {
        builder.contextDatetime = "session"
    }
}

class CustomBuilder : ArgumentBuilder {
    override val builderStorage = LinkedHashMapBuilderStorage()

    var task by string()
}

class CustomBuildDirector : ArgumentBuildDirector<CustomBuilder> {
    override fun constructArgument(builder: CustomBuilder) {
        builder.task = "from-custom-build-director"
    }
}

class ArgumentBuildDirectorTest {
    @Test
    fun testCombineTwoDirectorsWithSameBuilderType() {
        val director = Jwt() + Session()
        val builder = CustomBuilder()
        director.constructArgument(builder)

        assertEquals("jwt", builder.uniqueId)
        assertEquals("session", builder.contextDatetime)
    }

    @Test
    fun testCombineTwoDirectorsWithDifferentBuilderType() {
        val director = Jwt() + CustomBuildDirector()
        val builder = CustomBuilder()
        director.constructArgument(builder)

        assertEquals("jwt", builder.uniqueId)
        assertEquals("from-custom-build-director", builder.task)
    }

    @Test
    fun testCombineThreeDirector() {
        val director = Jwt() + Session() + CustomBuildDirector()
        val builder = CustomBuilder()
        director.constructArgument(builder)

        assertEquals("jwt", builder.uniqueId)
        assertEquals("session", builder.contextDatetime)
        assertEquals("from-custom-build-director", builder.task)
    }
}