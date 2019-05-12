package net.ntworld.hexagon.foundation.builder

fun <T : Any> Builder.generic(name: String? = null, default: T? = null) =
    GenericProperty(GenericPropertyOptions(name, default))

fun <T : Any> Builder.generic(block: GenericPropertyOptions<T>.() -> Unit) =
    GenericProperty(GenericPropertyOptions<T>().apply(block))

fun <T : Any> Builder.type(name: String? = null, default: T? = null) = generic(name, default)

fun <T : Any> Builder.type(block: GenericPropertyOptions<T>.() -> Unit) = generic(block)

fun Builder.boolean(name: String? = null, default: Boolean? = null) = generic(name, default)
fun Builder.boolean(block: GenericPropertyOptions<Boolean>.() -> Unit) = generic(block)

fun Builder.byte(name: String? = null, default: Byte? = null) = generic(name, default)
fun Builder.byte(block: GenericPropertyOptions<Byte>.() -> Unit) = generic(block)

fun Builder.short(name: String? = null, default: Short? = null) = generic(name, default)
fun Builder.short(block: GenericPropertyOptions<Short>.() -> Unit) = generic(block)

fun Builder.int(name: String? = null, default: Int? = null) = generic(name, default)
fun Builder.int(block: GenericPropertyOptions<Int>.() -> Unit) = generic(block)

fun Builder.long(name: String? = null, default: Long? = null) = generic(name, default)
fun Builder.long(block: GenericPropertyOptions<Long>.() -> Unit) = generic(block)

fun Builder.float(name: String? = null, default: Float? = null) = generic(name, default)
fun Builder.float(block: GenericPropertyOptions<Float>.() -> Unit) = generic(block)

fun Builder.double(name: String? = null, default: Double? = null) = generic(name, default)
fun Builder.double(block: GenericPropertyOptions<Double>.() -> Unit) = generic(block)

fun Builder.char(name: String? = null, default: Char? = null) = generic(name, default)
fun Builder.char(block: GenericPropertyOptions<Char>.() -> Unit) = generic(block)

fun Builder.string(
    sanitize: ((String) -> String)? = null,
    trim: Boolean = false,
    uppercase: Boolean = false,
    lowercase: Boolean,
    name: String? = null,
    default: String? = null
) = StringProperty(StringPropertyOptions(name, default, trim, uppercase, lowercase, sanitize))

fun Builder.string(block: StringPropertyOptions.() -> Unit) =
    StringProperty(StringPropertyOptions().apply(block))

// fun <T> Builder.array(name: String? = null, default: Array<T>? = null) = type(name, default)
// fun <T> Builder.array(block: GenericPropertyOptions<Array<T>>.() -> Unit) = type(block)