package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.BUILDER_KEY_CONTEXT_DATETIME
import net.ntworld.hexagon.foundation.internal.BUILDER_KEY_UNIQUE_ID
import kotlin.test.Test
import kotlin.test.assertEquals

class Jwt : ArgumentBuildDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {
        builder.setUniqueId("jwt")
    }
}

class Session : ArgumentBuildDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {
        builder.setContextDatetime("session")
    }
}

class CustomBuilder : ArgumentBuilderBase() {
    fun setTask(task: String) {
        this["task"] = task
    }
}

class CustomBuildDirector : ArgumentBuildDirector<CustomBuilder> {
    override fun constructArgument(builder: CustomBuilder) {
        builder.setTask("from-custom-build-director")
    }
}

class ArgumentBuildDirectorTest {
    @Test
    fun testCombineTwoDirectorsWithSameBuilderType() {
        val director = Jwt() + Session()
        val builder = CustomBuilder()
        director.constructArgument(builder)

        assertEquals("jwt", builder[BUILDER_KEY_UNIQUE_ID])
        assertEquals("session", builder[BUILDER_KEY_CONTEXT_DATETIME])
    }

    @Test
    fun testCombineTwoDirectorsWithDifferentBuilderType() {
        val director = Jwt() + CustomBuildDirector()
        val builder = CustomBuilder()
        director.constructArgument(builder)

        assertEquals("jwt", builder[BUILDER_KEY_UNIQUE_ID])
        assertEquals("from-custom-build-director", builder["task"])
    }

    @Test
    fun testCombineThreeDirector() {
        val director = Jwt() + Session() + CustomBuildDirector()
        val builder = CustomBuilder()
        director.constructArgument(builder)

        assertEquals("jwt", builder[BUILDER_KEY_UNIQUE_ID])
        assertEquals("session", builder[BUILDER_KEY_CONTEXT_DATETIME])
        assertEquals("from-custom-build-director", builder["task"])
    }
}