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
        class SampleBuilder : Builder, TestValidation {

            override val builderStorage = LinkedHashMapBuilderStorage()

            override var x by string()
            var a by string()
            var b by string(default = "test")
        }

        val builder = SampleBuilder()

        var result = builder.validate {
            builder::a always required otherwise {
                builder::a.name + " is required (custom message)"
            }
        }
        assertFalse(result.isValid)

        result = builder.validate {
            builder::b always required
        }
        assertTrue(result.isValid)


        val validator = Validator<SampleBuilder> {
            SampleBuilder::a always required
        }
        val x = validator.validate(builder)
        println(x)

    }

    interface TestValidation {
        var x: String
    }

    @Test
    fun testGlobalValidator() {
        val validator = Validator<TestValidation> {
            TestValidation::x always required
        }
        println(
            validator.validate(object : TestValidation {
                override var x = ""
            })
        )
    }
}