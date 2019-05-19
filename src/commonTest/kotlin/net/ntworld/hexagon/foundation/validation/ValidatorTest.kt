package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.builder.*
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ValidatorTest {
    @Test
    fun testMustSyntax() {
        class SampleBuilder: Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var a by string()
            var b by string(default = "test")
        }
        val builder = SampleBuilder()

        var result = builder.validate {
            builder::a always required
        }
        assertFalse(result.isValid)

        result = builder.validate {
            builder::b always required
        }
        assertTrue(result.isValid)
    }
}