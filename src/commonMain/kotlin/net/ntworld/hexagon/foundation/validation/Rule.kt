package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import net.ntworld.hexagon.foundation.ArgumentValidator
import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.validation.rule.GreaterThan
import net.ntworld.hexagon.foundation.validation.rule.GreaterThanOrEqual
import net.ntworld.hexagon.foundation.validation.rule.NotEmpty
import net.ntworld.hexagon.foundation.validation.rule.Required
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

    val required: Rule = Required()
    val notEmpty: Rule = NotEmpty()

    val gt: (value: Int) -> Rule = fun(value: Int): Rule {
        return GreaterThan(value)
    }

    val greaterThan: (value: Int) -> Rule = fun(value: Int): Rule {
        return GreaterThan(value)
    }

    val gte: (value: Int) -> Rule = fun(value: Int): Rule {
        return GreaterThanOrEqual(value)
    }

    val greaterThanOrEqual: (value: Int) -> Rule = fun(value: Int): Rule {
        return GreaterThanOrEqual(value)
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


fun test() {
    Validator<Test> {
        Test::task {
            rule = required
            message = "required"
        }

        Test::task should gt(3) and required and notEmpty otherwise {
            message = "required"
        }
    }
}