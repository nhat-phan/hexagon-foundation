package net.ntworld.hexagon.foundation.validation

interface RuleCollection<T : Any> : Rule<T> {
    fun addAll(rules: RuleCollection<T>)

    infix fun customMessage(message: String)

    infix fun and(rule: Rule<T>): RuleCollection<T>

    operator fun plus(rule: Rule<T>): RuleCollection<T>
}