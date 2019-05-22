package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.RuleCollection

open class RuleCollectionImpl<T : Any> : RuleCollection<T> {
    val collection: MutableList<Rule<T>> = mutableListOf()

    override val message: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun passes(attribute: String, value: T): Boolean {
        for (item in collection) {
            item.passes(attribute, value)
        }
        return true
    }

    override fun addAll(rule: RuleCollection<T>) {
        TODO()
    }

    override infix fun and(rule: Rule<T>): RuleCollection<T> {
        collection.add(rule)

        return this
    }

    override operator fun plus(rule: Rule<T>): RuleCollection<T> {
        TODO()
    }

    override infix fun customMessage(message: String) {

    }

    internal fun validate(attribute: String, value: T?): Boolean {
        TODO()
    }

    internal fun buildErrorMessages(errors: MessageBag, attribute: String, value: T?): Boolean {
        TODO()
    }
}