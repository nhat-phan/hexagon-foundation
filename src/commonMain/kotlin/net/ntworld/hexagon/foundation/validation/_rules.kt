package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.validation.rule.GreaterThan
import net.ntworld.hexagon.foundation.validation.rule.GreaterThanOrEqual
import net.ntworld.hexagon.foundation.validation.rule.NotEmpty
import net.ntworld.hexagon.foundation.validation.rule.Required

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