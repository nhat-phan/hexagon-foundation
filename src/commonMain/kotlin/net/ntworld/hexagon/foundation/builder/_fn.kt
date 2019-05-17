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

fun Builder.booleanArray(
    default: BooleanArray? = null,
    filter: ((Boolean) -> Boolean)? = null,
    map: ((Boolean) -> Boolean)? = null,
    sanitize: ((BooleanArray) -> BooleanArray)? = null
) = IterablePropertyFactory.makeBooleanArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.booleanArray(block: IterablePropertyOptions<Boolean, BooleanArray>.() -> Unit) =
    IterablePropertyFactory.makeBooleanArray(IterablePropertyOptions<Boolean, BooleanArray>().apply(block))

fun Builder.byteArray(
    default: ByteArray? = null,
    filter: ((Byte) -> Boolean)? = null,
    map: ((Byte) -> Byte)? = null,
    sanitize: ((ByteArray) -> ByteArray)? = null
) = IterablePropertyFactory.makeByteArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.byteArray(block: IterablePropertyOptions<Byte, ByteArray>.() -> Unit) =
    IterablePropertyFactory.makeByteArray(IterablePropertyOptions<Byte, ByteArray>().apply(block))

fun Builder.shortArray(
    default: ShortArray? = null,
    filter: ((Short) -> Boolean)? = null,
    map: ((Short) -> Short)? = null,
    sanitize: ((ShortArray) -> ShortArray)? = null
) = IterablePropertyFactory.makeShortArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.shortArray(block: IterablePropertyOptions<Short, ShortArray>.() -> Unit) =
    IterablePropertyFactory.makeShortArray(IterablePropertyOptions<Short, ShortArray>().apply(block))

fun Builder.intArray(
    default: IntArray? = null,
    filter: ((Int) -> Boolean)? = null,
    map: ((Int) -> Int)? = null,
    sanitize: ((IntArray) -> IntArray)? = null
) = IterablePropertyFactory.makeIntArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.intArray(block: IterablePropertyOptions<Int, IntArray>.() -> Unit) =
    IterablePropertyFactory.makeIntArray(IterablePropertyOptions<Int, IntArray>().apply(block))

fun Builder.longArray(
    default: LongArray? = null,
    filter: ((Long) -> Boolean)? = null,
    map: ((Long) -> Long)? = null,
    sanitize: ((LongArray) -> LongArray)? = null
) = IterablePropertyFactory.makeLongArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.longArray(block: IterablePropertyOptions<Long, LongArray>.() -> Unit) =
    IterablePropertyFactory.makeLongArray(IterablePropertyOptions<Long, LongArray>().apply(block))

fun Builder.floatArray(
    default: FloatArray? = null,
    filter: ((Float) -> Boolean)? = null,
    map: ((Float) -> Float)? = null,
    sanitize: ((FloatArray) -> FloatArray)? = null
) = IterablePropertyFactory.makeFloatArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.floatArray(block: IterablePropertyOptions<Float, FloatArray>.() -> Unit) =
    IterablePropertyFactory.makeFloatArray(IterablePropertyOptions<Float, FloatArray>().apply(block))

fun Builder.doubleArray(
    default: DoubleArray? = null,
    filter: ((Double) -> Boolean)? = null,
    map: ((Double) -> Double)? = null,
    sanitize: ((DoubleArray) -> DoubleArray)? = null
) = IterablePropertyFactory.makeDoubleArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.doubleArray(block: IterablePropertyOptions<Double, DoubleArray>.() -> Unit) =
    IterablePropertyFactory.makeDoubleArray(IterablePropertyOptions<Double, DoubleArray>().apply(block))

fun Builder.charArray(
    default: CharArray? = null,
    filter: ((Char) -> Boolean)? = null,
    map: ((Char) -> Char)? = null,
    sanitize: ((CharArray) -> CharArray)? = null
) = IterablePropertyFactory.makeCharArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.charArray(block: IterablePropertyOptions<Char, CharArray>.() -> Unit) =
    IterablePropertyFactory.makeCharArray(IterablePropertyOptions<Char, CharArray>().apply(block))

// -----------------------------------------------------
// Array is special one, we have to use inline & reified
// -----------------------------------------------------
inline fun <reified T> Builder.array(
    default: Array<T>? = null,
    noinline filter: ((T) -> Boolean)? = null,
    noinline map: ((T) -> T)? = null,
    noinline sanitize: ((Array<T>) -> Array<T>)? = null
) = makeArrayProperty(ArrayPropertyOptions(default, map, filter, sanitize))

inline fun <reified T> Builder.array(block: ArrayPropertyOptions<T>.() -> Unit) =
    makeArrayProperty(ArrayPropertyOptions<T>().apply(block))