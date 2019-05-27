package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.builder.*
import net.ntworld.hexagon.foundation.validation.internal.RuleExecutor
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ValidatorTest {
    @Test
    @JsName("test_object_syntax_with_builder_and_rule_equals_someRule")
    fun `test object syntax - { rule = --- }`() {
        val data = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string()
        }

        val result = data.validate {
            data::string { rule = notEmptyString }
        }
        assertFalse(result.isValid)
        assertErrorMessages(result, "string", MESSAGE_NOT_EMPTY_STRING)
    }

    @Test
    @JsName("test_object_syntax_required_with_builder_and_rule_equals_someRule")
    fun `test object syntax - required { rule = --- }`() {
        val data = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string()
        }

        val result = data.validate {
            data::string required { rule = notEmptyString }
        }
        assertFalse(result.isValid)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED)
    }

    @Test
    @JsName("test_object_syntax_required_someRule")
    fun `test object syntax - required rule`() {
        val data = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string(default = "")
        }

        val result = data.validate {
            data::string required notEmptyString
        }
        assertFalse(result.isValid)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED)
    }

    @Test
    @JsName("test_object_syntax_always_required")
    fun `test object syntax - always required`() {
        val data = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string()
        }

        val result = data.validate {
            data::string always required
        }
        assertFalse(result.isValid)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED)
    }

    @Test
    @JsName("test_object_syntax_always_required_and_someRule")
    fun `test object syntax - always required and rule`() {
        val data = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string(default = "")
        }

        val result = data.validate {
            data::string always required and notEmptyString
        }
        assertFalse(result.isValid)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED)
    }

    @Test
    @JsName("test_object_syntax_required_with_empty_builder")
    fun `test object syntax - required {}`() {
        val data = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string()
        }

        val result = data.validate {
            data::string required {}
        }
        assertFalse(result.isValid)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED)
    }

    @Test
    fun testExtend_Validator() {
        open class ParentBuilder : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var number by int()
        }

        class SampleBuilder : ParentBuilder() {
            var string by string()
        }

        val validatorReused = Validator<ParentBuilder> {
            ParentBuilder::number always required and gt(10)
        }

        val validator = Validator<SampleBuilder> {
            extend(validatorReused)

            SampleBuilder::string always required
            SampleBuilder::number always required and lt(12)
        }

        val data = SampleBuilder()
        data.number = 15
        val result = data.validatedBy(validator)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED)
        assertErrorMessages(result, "number", MESSAGE_NUMBER_LESS_THAN.replace("{value}", "12"))
    }

    @Test
    fun testNestedValidatorBuilder_Validator() {
        data class Child(var age: Int)
        class ParentBuilder : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var child by type<Child>()
            var number by int()
        }

        val validator = Validator<ParentBuilder> {
            ParentBuilder::child required {
                Child::age always exists and gte(10)
            }

            ParentBuilder::number required gt(10) and eq(100)
        }

        println(validator)
        val builder = ParentBuilder()
        builder.child = Child(9)
        builder.number = 9
        println(validator.validate(builder))
    }

    @Test
    fun testEach_Object() {
        val builder = object : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var data by list<Int>()
        }

        builder.data = listOf(1, 2, 3)
        val result = builder.validate {
            builder::data always required
            builder::data each gt(12)
        }
        assertErrorMessages(result, "data", MESSAGE_EACH)
    }

    private fun assertErrorMessages(result: ValidationResult, attribute: String, vararg message: String) {
        val formattedMessages = message.map { formatMessage(it, attribute) }
        assertEquals(formattedMessages.toSet(), result.errors.get(attribute))
    }

    private fun formatMessage(message: String, attribute: String, value: String = ""): String {
        return RuleExecutor.formatMessage(message, attribute, value)
    }
}