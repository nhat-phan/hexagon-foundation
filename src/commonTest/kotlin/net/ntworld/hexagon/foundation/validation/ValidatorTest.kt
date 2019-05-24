package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.builder.Builder
import net.ntworld.hexagon.foundation.builder.LinkedHashMapBuilderStorage
import net.ntworld.hexagon.foundation.builder.int
import net.ntworld.hexagon.foundation.builder.string
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
        assertErrorMessages(result, "string", MESSAGE_REQUIRED, MESSAGE_NOT_EMPTY_STRING)
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
        assertErrorMessages(result, "string", MESSAGE_REQUIRED, MESSAGE_NOT_EMPTY_STRING)
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
        assertErrorMessages(result, "string", MESSAGE_REQUIRED, MESSAGE_NOT_EMPTY_STRING)
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
    fun testExtend() {
        class SampleBuilder : Builder {
            override val builderStorage = LinkedHashMapBuilderStorage()

            var string by string()
            var number by int()
        }

        val validatorReused = Validator<SampleBuilder> {
            SampleBuilder::string always required
        }

        val validator = Validator<SampleBuilder> {
            extend(validatorReused)

            SampleBuilder::string { rule = notEmptyString }
            SampleBuilder::number always required and gt(10)
        }

        val data = SampleBuilder()
        val result = data.validate(validator)
        assertErrorMessages(result, "string", MESSAGE_REQUIRED, MESSAGE_NOT_EMPTY_STRING)
        assertErrorMessages(
            result, "number",
            MESSAGE_REQUIRED,
            MESSAGE_NUMBER_GREATER_THAN.replace("{value}", "10")
        )
    }

    private fun assertErrorMessages(result: ValidationResult, attribute: String, vararg message: String) {
        val formattedMessages = message.map { formatMessage(it, attribute) }
        assertEquals(formattedMessages.toSet(), result.errors.get(attribute))
    }

    private fun formatMessage(message: String, attribute: String, value: String = ""): String {
        return message
            .replace(":attribute", attribute)
            .replace(":value", value)
    }
}