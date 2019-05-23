//package net.ntworld.hexagon.foundation.old_validation
//
//import net.ntworld.hexagon.foundation.builder.*
//import kotlin.test.Test
//import kotlin.test.assertTrue
//import kotlin.test.assertFalse
//
//class ValidatorTest {
//    interface TestInterface<T: Any> {
//        fun convertValue(value: Any): T?
//
//        fun doSomething(value: T?)
//
//        fun validate(value: Any) {
//            this.doSomething(this.convertValue(value))
//        }
//    }
//
//    class A: TestInterface<Int> {
//        override fun convertValue(value: Any): Int? {
//            if (value is Int) {
//                return value
//            }
//            return null
//        }
//
//        override fun doSomething(value: Int?) {
//            println("Int:" + value.toString())
//        }
//    }
//
//    class B: TestInterface<String> {
//        override fun convertValue(value: Any): String? {
//            if (value is String) {
//                return value
//            }
//            return null
//        }
//
//        override fun doSomething(value: String?) {
//            println("String:" + value.toString())
//        }
//    }
//
//    @Test
//    fun testCasting() {
//        val collection: MutableList<TestInterface<Any>> = mutableListOf()
//        collection.add(A() as TestInterface<Any>)
//        collection.add(B() as TestInterface<Any>)
//        val a: TestInterface<Int> = collection.first() as TestInterface<Int>
//        val b: TestInterface<String> = collection.last() as TestInterface<String>
//        // error
//        val c: TestInterface<String> = collection.first() as TestInterface<String>
//        val d: TestInterface<Int> = collection.last() as TestInterface<Int>
//        // c.doSomething("ABC")
//
////        for(item in collection) {
////            item.validate("123")
////        }
//    }
//
//
//    @Test
//    fun testMustSyntax() {
//        class SampleBuilder : Builder, TestValidation {
//
//            override val builderStorage = LinkedHashMapBuilderStorage()
//
//            override var x by string()
//            var a by string()
//            var b by string(default = "test")
//        }
//
//        val builder = SampleBuilder()
//
//        var result = builder.validate {
//            builder::a always required otherwise {
//                builder::a.name + " is required (custom message)"
//            }
//        }
//        assertFalse(result.isValid)
//
//        result = builder.validate {
//            builder::b always required
//        }
//        assertTrue(result.isValid)
//
//
//        val validator = Validator<SampleBuilder> {
//            SampleBuilder::a always required
//        }
//        val x = validator.validate(builder)
//        println(x)
//
//    }
//
//    interface TestValidation {
//        var x: String
//    }
//
//    @Test
//    fun testGlobalValidator() {
//        val validator = Validator<TestValidation> {
//            TestValidation::x always required
//        }
//        println(
//            validator.validate(object : TestValidation {
//                override var x = ""
//            })
//        )
//    }
//}