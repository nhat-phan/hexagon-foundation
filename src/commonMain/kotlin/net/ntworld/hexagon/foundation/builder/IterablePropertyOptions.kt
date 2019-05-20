package net.ntworld.hexagon.foundation.builder

interface IterablePropertyOptions<E : Any, T: Any>: GenericPropertyOptions<T> {
    var filter: (E) -> Boolean
    var map: (E) -> E
    var sanitize: (T) -> T
}