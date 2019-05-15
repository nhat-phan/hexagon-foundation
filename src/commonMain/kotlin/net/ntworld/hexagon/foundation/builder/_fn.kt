package net.ntworld.hexagon.foundation.builder

fun <T : Any> Builder.generic(default: T? = null) =
    GenericProperty(GenericPropertyOptions(default))

fun <T : Any> Builder.generic(block: GenericPropertyOptions<T>.() -> Unit) =
    GenericProperty(GenericPropertyOptions<T>().apply(block))

fun <T : Any> Builder.type(default: T? = null) = generic(default)

fun <T : Any> Builder.type(block: GenericPropertyOptions<T>.() -> Unit) = generic(block)

fun Builder.boolean(default: Boolean? = null) = generic(default)
fun Builder.boolean(block: GenericPropertyOptions<Boolean>.() -> Unit) = generic(block)

fun Builder.byte(default: Byte? = null) = generic(default)
fun Builder.byte(block: GenericPropertyOptions<Byte>.() -> Unit) = generic(block)

fun Builder.short(default: Short? = null) = generic(default)
fun Builder.short(block: GenericPropertyOptions<Short>.() -> Unit) = generic(block)

fun Builder.int(default: Int? = null) = generic(default)
fun Builder.int(block: GenericPropertyOptions<Int>.() -> Unit) = generic(block)

fun Builder.long(default: Long? = null) = generic(default)
fun Builder.long(block: GenericPropertyOptions<Long>.() -> Unit) = generic(block)

fun Builder.float(default: Float? = null) = generic(default)
fun Builder.float(block: GenericPropertyOptions<Float>.() -> Unit) = generic(block)

fun Builder.double(default: Double? = null) = generic(default)
fun Builder.double(block: GenericPropertyOptions<Double>.() -> Unit) = generic(block)

fun Builder.char(default: Char? = null) = generic(default)
fun Builder.char(block: GenericPropertyOptions<Char>.() -> Unit) = generic(block)

fun Builder.string(
    sanitize: ((String) -> String)? = null,
    trim: Boolean = false,
    uppercase: Boolean = false,
    lowercase: Boolean = false,
    default: String? = null
) = StringProperty(StringPropertyOptions(default, trim, uppercase, lowercase, sanitize))

fun Builder.string(block: StringPropertyOptions.() -> Unit) =
    StringProperty(StringPropertyOptions().apply(block))

fun <T> Builder.nullable(block: Builder.() -> Property<T>): NullableProperty<T> = NullableProperty(block.invoke(this))
fun <T> Builder.nullable(property: Property<T>): NullableProperty<T> = NullableProperty(property)

fun <T : Any> Builder.array(
    default: Array<T>? = null,
    filter: ((T) -> Boolean)? = null,
    map: ((T) -> T)? = null,
    sanitize: ((Array<T>) -> Array<T>)? = null
// ) = IterablePropertyFactory.makeArray(IterablePropertyOptions(default, filter, map, sanitize))
) = generic(default)

fun <T : Any> Builder.array(block: IterablePropertyOptions<T, Array<T>>.() -> Unit) =
    generic(block)
// IterablePropertyFactory.makeArray(IterablePropertyOptions<T, Array<T>>().apply(block))

fun Builder.booleanArray(
    default: BooleanArray? = null,
    filter: ((Boolean) -> Boolean)? = null,
    map: ((Boolean) -> Boolean)? = null,
    sanitize: ((BooleanArray) -> BooleanArray)? = null
) = IterablePropertyFactory.makeBooleanArray(IterablePropertyOptions(default, filter, map, sanitize))

fun Builder.booleanArray(block: IterablePropertyOptions<Boolean, BooleanArray>.() -> Unit) =
    IterablePropertyFactory.makeBooleanArray(IterablePropertyOptions<Boolean, BooleanArray>().apply(block))

fun Builder.byteArray(
    default: ByteArray? = null,
    filter: ((Byte) -> Boolean)? = null,
    map: ((Byte) -> Byte)? = null,
    sanitize: ((ByteArray) -> ByteArray)? = null
) = IterablePropertyFactory.makeByteArray(IterablePropertyOptions(default, filter, map, sanitize))

fun Builder.byteArray(block: IterablePropertyOptions<Byte, ByteArray>.() -> Unit) =
    IterablePropertyFactory.makeByteArray(IterablePropertyOptions<Byte, ByteArray>().apply(block))
