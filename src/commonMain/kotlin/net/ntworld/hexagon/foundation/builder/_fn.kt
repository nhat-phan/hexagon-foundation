package net.ntworld.hexagon.foundation.builder

import net.ntworld.hexagon.foundation.builder.internal.*

infix fun <T, BuilderInterface : Builder> BuilderInterface.convertTo(factory: (builder: BuilderInterface) -> T): T {
    return factory.invoke(this)
}

infix fun <T, BuilderInterface : Builder> BuilderInterface.to(factory: (builder: BuilderInterface) -> T): T {
    return factory.invoke(this)
}

// -----------------------------------------------------
// Generic
// -----------------------------------------------------

fun <T: Any> Builder.generic(default: T? = null): Property<T> =
    GenericProperty(GenericPropertyOptionsImpl(default))

fun <T: Any> Builder.generic(block: GenericPropertyOptions<T>.() -> Unit): Property<T> =
    GenericProperty(GenericPropertyOptionsImpl<T>().apply(block))

fun <T: Any> Builder.type(default: T? = null) = generic(default)

fun <T: Any> Builder.type(block: GenericPropertyOptions<T>.() -> Unit) = generic(block)

fun <T: Any> Builder.custom(default: T? = null) = generic(default)

fun <T: Any> Builder.custom(block: GenericPropertyOptions<T>.() -> Unit) = generic(block)

// -----------------------------------------------------
// Primitive types
// -----------------------------------------------------

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
): Property<String> = StringProperty(StringPropertyOptionsImpl(default, trim, uppercase, lowercase, sanitize))

fun Builder.string(block: StringPropertyOptions.() -> Unit): Property<String> =
    StringProperty(StringPropertyOptionsImpl().apply(block))

// -----------------------------------------------------
// TypedArray types
// -----------------------------------------------------

fun Builder.booleanArray(
    default: BooleanArray? = null,
    map: ((Boolean) -> Boolean)? = null,
    filter: ((Boolean) -> Boolean)? = null,
    sanitize: ((BooleanArray) -> BooleanArray)? = null
): Property<BooleanArray> =
    IterablePropertyFactory.makeBooleanArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.booleanArray(block: IterablePropertyOptions<Boolean, BooleanArray>.() -> Unit): Property<BooleanArray> =
    IterablePropertyFactory.makeBooleanArray(IterablePropertyOptionsImpl<Boolean, BooleanArray>().apply(block))

fun Builder.byteArray(
    default: ByteArray? = null,
    map: ((Byte) -> Byte)? = null,
    filter: ((Byte) -> Boolean)? = null,
    sanitize: ((ByteArray) -> ByteArray)? = null
): Property<ByteArray> =
    IterablePropertyFactory.makeByteArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.byteArray(block: IterablePropertyOptions<Byte, ByteArray>.() -> Unit): Property<ByteArray> =
    IterablePropertyFactory.makeByteArray(IterablePropertyOptionsImpl<Byte, ByteArray>().apply(block))

fun Builder.shortArray(
    default: ShortArray? = null,
    map: ((Short) -> Short)? = null,
    filter: ((Short) -> Boolean)? = null,
    sanitize: ((ShortArray) -> ShortArray)? = null
): Property<ShortArray> =
    IterablePropertyFactory.makeShortArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.shortArray(block: IterablePropertyOptions<Short, ShortArray>.() -> Unit): Property<ShortArray> =
    IterablePropertyFactory.makeShortArray(IterablePropertyOptionsImpl<Short, ShortArray>().apply(block))

fun Builder.intArray(
    default: IntArray? = null,
    map: ((Int) -> Int)? = null,
    filter: ((Int) -> Boolean)? = null,
    sanitize: ((IntArray) -> IntArray)? = null
): Property<IntArray> =
    IterablePropertyFactory.makeIntArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.intArray(block: IterablePropertyOptions<Int, IntArray>.() -> Unit): Property<IntArray> =
    IterablePropertyFactory.makeIntArray(IterablePropertyOptionsImpl<Int, IntArray>().apply(block))

fun Builder.longArray(
    default: LongArray? = null,
    map: ((Long) -> Long)? = null,
    filter: ((Long) -> Boolean)? = null,
    sanitize: ((LongArray) -> LongArray)? = null
): Property<LongArray> =
    IterablePropertyFactory.makeLongArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.longArray(block: IterablePropertyOptions<Long, LongArray>.() -> Unit): Property<LongArray> =
    IterablePropertyFactory.makeLongArray(IterablePropertyOptionsImpl<Long, LongArray>().apply(block))

fun Builder.floatArray(
    default: FloatArray? = null,
    map: ((Float) -> Float)? = null,
    filter: ((Float) -> Boolean)? = null,
    sanitize: ((FloatArray) -> FloatArray)? = null
): Property<FloatArray> =
    IterablePropertyFactory.makeFloatArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.floatArray(block: IterablePropertyOptions<Float, FloatArray>.() -> Unit): Property<FloatArray> =
    IterablePropertyFactory.makeFloatArray(IterablePropertyOptionsImpl<Float, FloatArray>().apply(block))

fun Builder.doubleArray(
    default: DoubleArray? = null,
    map: ((Double) -> Double)? = null,
    filter: ((Double) -> Boolean)? = null,
    sanitize: ((DoubleArray) -> DoubleArray)? = null
): Property<DoubleArray> =
    IterablePropertyFactory.makeDoubleArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.doubleArray(block: IterablePropertyOptions<Double, DoubleArray>.() -> Unit): Property<DoubleArray> =
    IterablePropertyFactory.makeDoubleArray(IterablePropertyOptionsImpl<Double, DoubleArray>().apply(block))

fun Builder.charArray(
    default: CharArray? = null,
    map: ((Char) -> Char)? = null,
    filter: ((Char) -> Boolean)? = null,
    sanitize: ((CharArray) -> CharArray)? = null
): Property<CharArray> =
    IterablePropertyFactory.makeCharArray(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun Builder.charArray(block: IterablePropertyOptions<Char, CharArray>.() -> Unit): Property<CharArray> =
    IterablePropertyFactory.makeCharArray(IterablePropertyOptionsImpl<Char, CharArray>().apply(block))

// -----------------------------------------------------
// Collection types
// -----------------------------------------------------

fun <E> Builder.collection(
    default: Collection<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Collection<E>) -> Collection<E>)? = null
): Property<Collection<E>> =
    IterablePropertyFactory.makeCollection(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun <E> Builder.collection(block: IterablePropertyOptions<E, Collection<E>>.() -> Unit): Property<Collection<E>> =
    IterablePropertyFactory.makeCollection(IterablePropertyOptionsImpl<E, Collection<E>>().apply(block))

fun <E> Builder.list(
    default: List<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((List<E>) -> List<E>)? = null
): Property<List<E>> = IterablePropertyFactory.makeList(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun <E> Builder.list(block: IterablePropertyOptions<E, List<E>>.() -> Unit): Property<List<E>> =
    IterablePropertyFactory.makeList(IterablePropertyOptionsImpl<E, List<E>>().apply(block))

fun <E> Builder.set(
    default: Set<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Set<E>) -> Set<E>)? = null
): Property<Set<E>> = IterablePropertyFactory.makeSet(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun <E> Builder.set(block: IterablePropertyOptions<E, Set<E>>.() -> Unit): Property<Set<E>> =
    IterablePropertyFactory.makeSet(IterablePropertyOptionsImpl<E, Set<E>>().apply(block))

fun <K, V> Builder.map(
    default: Map<K, V>? = null,
    map: ((Map.Entry<K, V>) -> Map.Entry<K, V>)? = null,
    filter: ((Map.Entry<K, V>) -> Boolean)? = null,
    sanitize: ((Map<K, V>) -> Map<K, V>)? = null
): Property<Map<K, V>> = IterablePropertyFactory.makeMap(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun <K, V> Builder.map(block: IterablePropertyOptions<Map.Entry<K, V>, Map<K, V>>.() -> Unit): Property<Map<K, V>> =
    IterablePropertyFactory.makeMap(IterablePropertyOptionsImpl<Map.Entry<K, V>, Map<K, V>>().apply(block))

fun <E> Builder.arrayList(
    default: ArrayList<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((ArrayList<E>) -> ArrayList<E>)? = null
): Property<ArrayList<E>> =
    IterablePropertyFactory.makeArrayList(IterablePropertyOptionsImpl(default, map, filter, sanitize))

fun <E> Builder.arrayList(block: IterablePropertyOptions<E, ArrayList<E>>.() -> Unit): Property<ArrayList<E>> =
    IterablePropertyFactory.makeArrayList(IterablePropertyOptionsImpl<E, ArrayList<E>>().apply(block))

// -----------------------------------------------------
// Array is special one, we have to use inline & reified
// -----------------------------------------------------

inline fun <reified T> Builder.array(
    default: Array<T>? = null,
    noinline map: ((T) -> T)? = null,
    noinline filter: ((T) -> Boolean)? = null,
    noinline sanitize: ((Array<T>) -> Array<T>)? = null
): Property<Array<T>> = makeArrayProperty(ArrayPropertyOptions(default, map, filter, sanitize))

inline fun <reified T> Builder.array(block: ArrayPropertyOptions<T>.() -> Unit): Property<Array<T>> =
    makeArrayProperty(ArrayPropertyOptions<T>().apply(block))


// -----------------------------------------------------
// Nullable
// -----------------------------------------------------

fun <T> Builder.nullable(block: Builder.() -> Property<T>): Property<T?> = NullableProperty(block.invoke(this))
fun <T> Builder.nullable(property: Property<T>): Property<T?> = NullableProperty(property)

// -----------------------------------------------------
// Nullable Primitive types
// -----------------------------------------------------

fun Builder.nullableBoolean(default: Boolean? = null) = nullable(boolean(default))
fun Builder.nullableBoolean(block: GenericPropertyOptions<Boolean>.() -> Unit) = nullable(boolean(block))

fun Builder.nullableByte(default: Byte? = null) = nullable(byte(default))
fun Builder.nullableByte(block: GenericPropertyOptions<Byte>.() -> Unit) = nullable(byte(block))

fun Builder.nullableShort(default: Short? = null) = nullable(short(default))
fun Builder.nullableShort(block: GenericPropertyOptions<Short>.() -> Unit) = nullable(short(block))

fun Builder.nullableInt(default: Int? = null) = nullable(int(default))
fun Builder.nullableInt(block: GenericPropertyOptions<Int>.() -> Unit) = nullable(int(block))

fun Builder.nullableLong(default: Long? = null) = nullable(long(default))
fun Builder.nullableLong(block: GenericPropertyOptions<Long>.() -> Unit) = nullable(long(block))

fun Builder.nullableFloat(default: Float? = null) = nullable(float(default))
fun Builder.nullableFloat(block: GenericPropertyOptions<Float>.() -> Unit) = nullable(float(block))

fun Builder.nullableDouble(default: Double? = null) = nullable(double(default))
fun Builder.nullableDouble(block: GenericPropertyOptions<Double>.() -> Unit) = nullable(double(block))

fun Builder.nullableChar(default: Char? = null) = nullable(char(default))
fun Builder.nullableChar(block: GenericPropertyOptions<Char>.() -> Unit) = nullable(char(block))

fun Builder.nullableString(
    sanitize: ((String) -> String)? = null,
    trim: Boolean = false,
    uppercase: Boolean = false,
    lowercase: Boolean = false,
    default: String? = null
) = nullable(string(sanitize, trim, uppercase, lowercase, default))

fun Builder.nullableString(block: StringPropertyOptions.() -> Unit) = nullable(string(block))

// -----------------------------------------------------
// Nullable TypedArray types
// -----------------------------------------------------

fun Builder.nullableBooleanArray(
    default: BooleanArray? = null,
    map: ((Boolean) -> Boolean)? = null,
    filter: ((Boolean) -> Boolean)? = null,
    sanitize: ((BooleanArray) -> BooleanArray)? = null
) = nullable(booleanArray(default, map, filter, sanitize))

fun Builder.nullableBooleanArray(block: IterablePropertyOptions<Boolean, BooleanArray>.() -> Unit) =
    nullable(booleanArray(block))

fun Builder.nullableByteArray(
    default: ByteArray? = null,
    map: ((Byte) -> Byte)? = null,
    filter: ((Byte) -> Boolean)? = null,
    sanitize: ((ByteArray) -> ByteArray)? = null
) = nullable(byteArray(default, map, filter, sanitize))

fun Builder.nullableByteArray(block: IterablePropertyOptions<Byte, ByteArray>.() -> Unit) =
    nullable(byteArray(block))

fun Builder.nullableShortArray(
    default: ShortArray? = null,
    map: ((Short) -> Short)? = null,
    filter: ((Short) -> Boolean)? = null,
    sanitize: ((ShortArray) -> ShortArray)? = null
) = nullable(shortArray(default, map, filter, sanitize))

fun Builder.nullableShortArray(block: IterablePropertyOptions<Short, ShortArray>.() -> Unit) =
    nullable(shortArray(block))

fun Builder.nullableIntArray(
    default: IntArray? = null,
    map: ((Int) -> Int)? = null,
    filter: ((Int) -> Boolean)? = null,
    sanitize: ((IntArray) -> IntArray)? = null
) = nullable(intArray(default, map, filter, sanitize))

fun Builder.nullableIntArray(block: IterablePropertyOptions<Int, IntArray>.() -> Unit) =
    nullable(intArray(block))

fun Builder.nullableLongArray(
    default: LongArray? = null,
    map: ((Long) -> Long)? = null,
    filter: ((Long) -> Boolean)? = null,
    sanitize: ((LongArray) -> LongArray)? = null
) = nullable(longArray(default, map, filter, sanitize))

fun Builder.nullableLongArray(block: IterablePropertyOptions<Long, LongArray>.() -> Unit) =
    nullable(longArray(block))

fun Builder.nullableFloatArray(
    default: FloatArray? = null,
    map: ((Float) -> Float)? = null,
    filter: ((Float) -> Boolean)? = null,
    sanitize: ((FloatArray) -> FloatArray)? = null
) = nullable(floatArray(default, map, filter, sanitize))

fun Builder.nullableFloatArray(block: IterablePropertyOptions<Float, FloatArray>.() -> Unit) =
    nullable(floatArray(block))

fun Builder.nullableDoubleArray(
    default: DoubleArray? = null,
    map: ((Double) -> Double)? = null,
    filter: ((Double) -> Boolean)? = null,
    sanitize: ((DoubleArray) -> DoubleArray)? = null
) = nullable(doubleArray(default, map, filter, sanitize))

fun Builder.nullableDoubleArray(block: IterablePropertyOptions<Double, DoubleArray>.() -> Unit) =
    nullable(doubleArray(block))

fun Builder.nullableCharArray(
    default: CharArray? = null,
    map: ((Char) -> Char)? = null,
    filter: ((Char) -> Boolean)? = null,
    sanitize: ((CharArray) -> CharArray)? = null
) = nullable(charArray(default, map, filter, sanitize))

fun Builder.nullableCharArray(block: IterablePropertyOptions<Char, CharArray>.() -> Unit) =
    nullable(charArray(block))

// -----------------------------------------------------
// Nullable Collection types
// -----------------------------------------------------

fun <E> Builder.nullableCollection(
    default: Collection<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Collection<E>) -> Collection<E>)? = null
) = nullable(collection(default, map, filter, sanitize))

fun <E> Builder.nullableCollection(block: IterablePropertyOptions<E, Collection<E>>.() -> Unit) =
    nullable(collection(block))

fun <E> Builder.nullableList(
    default: List<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((List<E>) -> List<E>)? = null
) = nullable(list(default, map, filter, sanitize))

fun <E> Builder.nullableList(block: IterablePropertyOptions<E, List<E>>.() -> Unit) =
    nullable(list(block))

fun <E> Builder.nullableSet(
    default: Set<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Set<E>) -> Set<E>)? = null
) = nullable(set(default, map, filter, sanitize))

fun <E> Builder.nullableSet(block: IterablePropertyOptions<E, Set<E>>.() -> Unit) =
    nullable(set(block))

fun <K, V> Builder.nullableMap(
    default: Map<K, V>? = null,
    map: ((Map.Entry<K, V>) -> Map.Entry<K, V>)? = null,
    filter: ((Map.Entry<K, V>) -> Boolean)? = null,
    sanitize: ((Map<K, V>) -> Map<K, V>)? = null
) = nullable(map(default, map, filter, sanitize))

fun <K, V> Builder.nullableMap(block: IterablePropertyOptions<Map.Entry<K, V>, Map<K, V>>.() -> Unit) =
    nullable(map(block))

fun <E> Builder.nullableArrayList(
    default: ArrayList<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((ArrayList<E>) -> ArrayList<E>)? = null
) = nullable(arrayList(default, map, filter, sanitize))

fun <E> Builder.nullableArrayList(block: IterablePropertyOptions<E, ArrayList<E>>.() -> Unit) =
    nullable(arrayList(block))

// -----------------------------------------------------
// Nullable Array
// -----------------------------------------------------

inline fun <reified T> Builder.nullableArray(
    default: Array<T>? = null,
    noinline map: ((T) -> T)? = null,
    noinline filter: ((T) -> Boolean)? = null,
    noinline sanitize: ((Array<T>) -> Array<T>)? = null
) = nullable(array(default, map, filter, sanitize))

inline fun <reified T> Builder.nullableArray(block: ArrayPropertyOptions<T>.() -> Unit) =
    nullable(array(block))
