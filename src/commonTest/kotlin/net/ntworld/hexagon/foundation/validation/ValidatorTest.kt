package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.builder.Builder
import net.ntworld.hexagon.foundation.builder.LinkedHashMapBuilderStorage
import net.ntworld.hexagon.foundation.builder.int
import net.ntworld.hexagon.foundation.builder.string
import kotlin.js.JsName
import kotlin.test.Test
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
        println(result)
    }
}