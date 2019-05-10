package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import net.ntworld.hexagon.foundation.ArgumentValidator
import net.ntworld.hexagon.foundation.ValidationResult
import kotlin.reflect.KProperty

interface Rule {
    val message: String

    fun passes(attribute: String, value: Any?): Boolean
}

class Validator<T : ArgumentBuilderBase>(block: ValidatorBuilder.() -> Unit) : ArgumentValidator<T> {
    override fun validate(builder: T): ValidationResult {
        TODO("")
    }
}

class ValidatorBuilder {
    operator fun <R> KProperty<R>.invoke(block: ValidatorRuleBuilder.() -> Unit) {

    }

    infix fun <R> KProperty<R>.should(rule: Rule): ValidatorRuleBuilder {
        TODO()
    }
}

class ValidatorRuleBuilder {
    private var _rule: Rule? = null

    var rule: Rule
        get() {
            throw Exception("Not allow")
        }
        set(value: Rule) {
            _rule = value
        }

    var message: String = ""

    infix fun otherwise(block: ValidatorRuleBuilder.() -> Unit) {
        TODO()
    }

    infix fun and(rule: Rule): ValidatorRuleBuilder {
        TODO()
    }
}

class Test : ArgumentBuilderBase() {
    var task: String by this
}

operator fun Rule.plus(rule: Rule): Rule {
    TODO("here")
}

object required: Rule {
    override val message: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun passes(attribute: String, value: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

object notEmpty: Rule {
    override val message: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun passes(attribute: String, value: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun test() {
    Validator<Test> {
        Test::task {
            rule = required
            message = "required"
        }

        Test::task should notEmpty and required otherwise {
            message = "required"
        }
    }
}