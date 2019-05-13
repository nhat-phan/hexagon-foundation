package net.ntworld.hexagon.foundation.builder

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BuilderTest {
    interface PrimitivePropertyBuilder<T> : Builder {
        var property: T

        var propertyNamed: T

        var propertyWithDefaultValue: T

        var propertyNamedWithDefaultValue: T
    }

    @Test
    fun testPrimitiveProperties() {
        class BooleanBuilder : PrimitivePropertyBuilder<Boolean> {
            override val builderStorage = HashMapBuilderStorage()

            override var property by boolean()
            override var propertyNamed by boolean(name = "property_named")
            override var propertyWithDefaultValue by boolean(default = true)
            override var propertyNamedWithDefaultValue by boolean(name = "property_named_with_default", default = true)
        }
        runPrimitivePropertyBuilderTest(BooleanBuilder(), true, false)

        class ByteBuilder : PrimitivePropertyBuilder<Byte> {
            override val builderStorage = HashMapBuilderStorage()

            override var property by byte()
            override var propertyNamed by byte(name = "property_named")
            override var propertyWithDefaultValue by byte(default = 127)
            override var propertyNamedWithDefaultValue by byte(name = "property_named_with_default", default = 127)
        }
        runPrimitivePropertyBuilderTest(ByteBuilder(), 127, 49)
    }

    private fun <T> runPrimitivePropertyBuilderTest(
        builder: PrimitivePropertyBuilder<T>,
        defaultValue: T,
        testValue: T
    ) {
        assertFalse(builder.builderStorage.containsKey("propertyWithDefaultValue"))
        assertEquals(defaultValue, builder.propertyWithDefaultValue)

        assertFalse(builder.builderStorage.containsKey("property_named_with_default"))
        assertEquals(defaultValue, builder.propertyNamedWithDefaultValue)

        builder.propertyWithDefaultValue = testValue
        assertTrue(builder.builderStorage.containsKey("propertyWithDefaultValue"))
        assertEquals(testValue, builder.propertyWithDefaultValue)

        builder.propertyNamedWithDefaultValue = testValue
        assertTrue(builder.builderStorage.containsKey("property_named_with_default"))
        assertEquals(testValue, builder.propertyNamedWithDefaultValue)
    }

    @Test
    fun testStringProperty() {
        class SampleBuilder : Builder {
            override val builderStorage = HashMapBuilderStorage()

            var a by string()
            var b by string(trim = true)
            var c by string(trim = true, uppercase = true)
            var d by string(trim = true, lowercase = true)
            var e by string(trim = true, sanitize = { it.toUpperCase() })
            var f by string(uppercase = true)
            var g by string(lowercase = true)
            var h by string(sanitize = { it.toUpperCase() })
        }

        val builder = SampleBuilder()
        builder.a = "   VaLuE   "
        assertEquals("   VaLuE   ", builder.a)

        builder.b = "   VaLuE   "
        assertEquals("VaLuE", builder.b)

        builder.c = "   VaLuE   "
        assertEquals("VALUE", builder.c)

        builder.d = "   VaLuE   "
        assertEquals("value", builder.d)

        builder.e = "   VaLuE   "
        assertEquals("VALUE", builder.e)

        builder.f = "   VaLuE   "
        assertEquals("   VALUE   ", builder.f)

        builder.g = "   VaLuE   "
        assertEquals("   value   ", builder.g)

        builder.h = "   VaLuE   "
        assertEquals("   VALUE   ", builder.h)

        class SampleWithDefaultBuilder : Builder {
            override val builderStorage = HashMapBuilderStorage()

            var a by string(default = " Test ")
            var b by string(default = " Test ", trim = true)
            var c by string(default = " Test ", trim = true, uppercase = true)
            var d by string(default = " Test ", trim = true, lowercase = true)
            var e by string(default = " Test ", trim = true, sanitize = { it.toUpperCase() })
            var f by string(default = " Test ", uppercase = true)
            var g by string(default = " Test ", lowercase = true)
            var h by string(default = " Test ", sanitize = { it.toUpperCase() })
        }
        val builderWithDefault = SampleWithDefaultBuilder()

        assertEquals(" Test ", builderWithDefault.a)
        builderWithDefault.a = "   VaLuE   "
        assertEquals("   VaLuE   ", builderWithDefault.a)

        assertEquals("Test", builderWithDefault.b)
        builderWithDefault.b = "   VaLuE   "
        assertEquals("VaLuE", builderWithDefault.b)

        assertEquals("TEST", builderWithDefault.c)
        builderWithDefault.c = "   VaLuE   "
        assertEquals("VALUE", builderWithDefault.c)

        assertEquals("test", builderWithDefault.d)
        builderWithDefault.d = "   VaLuE   "
        assertEquals("value", builderWithDefault.d)

        assertEquals("TEST", builderWithDefault.e)
        builderWithDefault.e = "   VaLuE   "
        assertEquals("VALUE", builderWithDefault.e)

        assertEquals(" TEST ", builderWithDefault.f)
        builderWithDefault.f = "   VaLuE   "
        assertEquals("   VALUE   ", builderWithDefault.f)

        assertEquals(" test ", builderWithDefault.g)
        builderWithDefault.g = "   VaLuE   "
        assertEquals("   value   ", builderWithDefault.g)

        assertEquals(" TEST ", builderWithDefault.h)
        builderWithDefault.h = "   VaLuE   "
        assertEquals("   VALUE   ", builderWithDefault.h)
    }
}