package net.ntworld.hexagon.foundation.builder

fun <T : Any> Builder.type(name: String? = null, default: T? = null) =
    GenericProperty(GenericPropertyOptions(name, default))

fun <T : Any> Builder.type(block: GenericPropertyOptions<T>.() -> Unit) =
    GenericProperty(GenericPropertyOptions<T>().apply(block))

fun Builder.boolean(name: String? = null, default: Boolean? = null) = type(name, default)
fun Builder.boolean(block: GenericPropertyOptions<Boolean>.() -> Unit) = type(block)

fun Builder.byte(name: String? = null, default: Byte? = null) = type(name, default)
fun Builder.byte(block: GenericPropertyOptions<Byte>.() -> Unit) = type(block)

fun Builder.short(name: String? = null, default: Short? = null) = type(name, default)
fun Builder.short(block: GenericPropertyOptions<Short>.() -> Unit) = type(block)

fun Builder.int(name: String? = null, default: Int? = null) = type(name, default)
fun Builder.int(block: GenericPropertyOptions<Int>.() -> Unit) = type(block)

fun Builder.long(name: String? = null, default: Long? = null) = type(name, default)
fun Builder.long(block: GenericPropertyOptions<Long>.() -> Unit) = type(block)

fun Builder.float(name: String? = null, default: Float? = null) = type(name, default)
fun Builder.float(block: GenericPropertyOptions<Float>.() -> Unit) = type(block)

fun Builder.double(name: String? = null, default: Double? = null) = type(name, default)
fun Builder.double(block: GenericPropertyOptions<Double>.() -> Unit) = type(block)

// fun <T> Builder.array(name: String? = null, default: Array<T>? = null) = type(name, default)
// fun <T> Builder.array(block: GenericPropertyOptions<Array<T>>.() -> Unit) = type(block)
