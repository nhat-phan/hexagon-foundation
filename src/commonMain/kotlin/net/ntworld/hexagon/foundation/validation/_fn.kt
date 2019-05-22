package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.validation.internal.RuleCollectionImpl
import net.ntworld.hexagon.foundation.validation.rule.Optional

infix fun <T : Any> Rule<T>.and(rule: Rule<T>): Rule<T> {
    if (this is RuleCollectionImpl<T>) {
        return this.addRule(rule)
    }

    if (rule is RuleCollectionImpl<T>) {
        return rule.addRule(this)
    }

    return RuleCollectionImpl<T>(Optional()).addRule(this).addRule(rule)
}

operator fun <T : Any> Rule<T>.plus(rule: Rule<T>): Rule<T> {
    return this.and(rule)
}