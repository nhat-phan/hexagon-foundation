package net.ntworld.hexagon.foundation.builder

// -----------------------------------------------------
// Generic
// -----------------------------------------------------

fun <T : Any> Builder.generic(default: T? = null) =
    GenericProperty(GenericPropertyOptions(default))

fun <T : Any> Builder.generic(block: GenericPropertyOptions<T>.() -> Unit) =
    GenericProperty(GenericPropertyOptions<T>().apply(block))

fun <T : Any> Builder.type(default: T? = null) = generic(default)

fun <T : Any> Builder.type(block: GenericPropertyOptions<T>.() -> Unit) = generic(block)

fun <T : Any> Builder.custom(default: T? = null) = generic(default)

fun <T : Any> Builder.custom(block: GenericPropertyOptions<T>.() -> Unit) = generic(block)

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
) = StringProperty(StringPropertyOptions(default, trim, uppercase, lowercase, sanitize))

fun Builder.string(block: StringPropertyOptions.() -> Unit) =
    StringProperty(StringPropertyOptions().apply(block))

// -----------------------------------------------------
// TypedArray types
// -----------------------------------------------------

fun Builder.booleanArray(
    default: BooleanArray? = null,
    map: ((Boolean) -> Boolean)? = null,
    filter: ((Boolean) -> Boolean)? = null,
    sanitize: ((BooleanArray) -> BooleanArray)? = null
) = IterablePropertyFactory.makeBooleanArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.booleanArray(block: IterablePropertyOptions<Boolean, BooleanArray>.() -> Unit) =
    IterablePropertyFactory.makeBooleanArray(IterablePropertyOptions<Boolean, BooleanArray>().apply(block))

fun Builder.byteArray(
    default: ByteArray? = null,
    map: ((Byte) -> Byte)? = null,
    filter: ((Byte) -> Boolean)? = null,
    sanitize: ((ByteArray) -> ByteArray)? = null
) = IterablePropertyFactory.makeByteArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.byteArray(block: IterablePropertyOptions<Byte, ByteArray>.() -> Unit) =
    IterablePropertyFactory.makeByteArray(IterablePropertyOptions<Byte, ByteArray>().apply(block))

fun Builder.shortArray(
    default: ShortArray? = null,
    map: ((Short) -> Short)? = null,
    filter: ((Short) -> Boolean)? = null,
    sanitize: ((ShortArray) -> ShortArray)? = null
) = IterablePropertyFactory.makeShortArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.shortArray(block: IterablePropertyOptions<Short, ShortArray>.() -> Unit) =
    IterablePropertyFactory.makeShortArray(IterablePropertyOptions<Short, ShortArray>().apply(block))

fun Builder.intArray(
    default: IntArray? = null,
    map: ((Int) -> Int)? = null,
    filter: ((Int) -> Boolean)? = null,
    sanitize: ((IntArray) -> IntArray)? = null
) = IterablePropertyFactory.makeIntArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.intArray(block: IterablePropertyOptions<Int, IntArray>.() -> Unit) =
    IterablePropertyFactory.makeIntArray(IterablePropertyOptions<Int, IntArray>().apply(block))

fun Builder.longArray(
    default: LongArray? = null,
    map: ((Long) -> Long)? = null,
    filter: ((Long) -> Boolean)? = null,
    sanitize: ((LongArray) -> LongArray)? = null
) = IterablePropertyFactory.makeLongArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.longArray(block: IterablePropertyOptions<Long, LongArray>.() -> Unit) =
    IterablePropertyFactory.makeLongArray(IterablePropertyOptions<Long, LongArray>().apply(block))

fun Builder.floatArray(
    default: FloatArray? = null,
    map: ((Float) -> Float)? = null,
    filter: ((Float) -> Boolean)? = null,
    sanitize: ((FloatArray) -> FloatArray)? = null
) = IterablePropertyFactory.makeFloatArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.floatArray(block: IterablePropertyOptions<Float, FloatArray>.() -> Unit) =
    IterablePropertyFactory.makeFloatArray(IterablePropertyOptions<Float, FloatArray>().apply(block))

fun Builder.doubleArray(
    default: DoubleArray? = null,
    map: ((Double) -> Double)? = null,
    filter: ((Double) -> Boolean)? = null,
    sanitize: ((DoubleArray) -> DoubleArray)? = null
) = IterablePropertyFactory.makeDoubleArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.doubleArray(block: IterablePropertyOptions<Double, DoubleArray>.() -> Unit) =
    IterablePropertyFactory.makeDoubleArray(IterablePropertyOptions<Double, DoubleArray>().apply(block))

fun Builder.charArray(
    default: CharArray? = null,
    map: ((Char) -> Char)? = null,
    filter: ((Char) -> Boolean)? = null,
    sanitize: ((CharArray) -> CharArray)? = null
) = IterablePropertyFactory.makeCharArray(IterablePropertyOptions(default, map, filter, sanitize))

fun Builder.charArray(block: IterablePropertyOptions<Char, CharArray>.() -> Unit) =
    IterablePropertyFactory.makeCharArray(IterablePropertyOptions<Char, CharArray>().apply(block))

// -----------------------------------------------------
// Collection types
// -----------------------------------------------------

fun <E : Any> Builder.collection(
    default: Collection<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Collection<E>) -> Collection<E>)? = null
) = IterablePropertyFactory.makeCollection(IterablePropertyOptions(default, map, filter, sanitize))

fun <E : Any> Builder.collection(block: IterablePropertyOptions<E, Collection<E>>.() -> Unit) =
    IterablePropertyFactory.makeCollection(IterablePropertyOptions<E, Collection<E>>().apply(block))

fun <E : Any> Builder.list(
    default: List<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((List<E>) -> List<E>)? = null
) = IterablePropertyFactory.makeList(IterablePropertyOptions(default, map, filter, sanitize))

fun <E : Any> Builder.list(block: IterablePropertyOptions<E, List<E>>.() -> Unit) =
    IterablePropertyFactory.makeList(IterablePropertyOptions<E, List<E>>().apply(block))

fun <E : Any> Builder.set(
    default: Set<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Set<E>) -> Set<E>)? = null
) = IterablePropertyFactory.makeSet(IterablePropertyOptions(default, map, filter, sanitize))

fun <E : Any> Builder.set(block: IterablePropertyOptions<E, Set<E>>.() -> Unit) =
    IterablePropertyFactory.makeSet(IterablePropertyOptions<E, Set<E>>().apply(block))

fun <K, V> Builder.map(
    default: Map<K, V>? = null,
    map: ((Map.Entry<K, V>) -> Map.Entry<K, V>)? = null,
    filter: ((Map.Entry<K, V>) -> Boolean)? = null,
    sanitize: ((Map<K, V>) -> Map<K, V>)? = null
) = IterablePropertyFactory.makeMap(IterablePropertyOptions(default, map, filter, sanitize))

fun <K, V> Builder.map(block: IterablePropertyOptions<Map.Entry<K, V>, Map<K, V>>.() -> Unit) =
    IterablePropertyFactory.makeMap(IterablePropertyOptions<Map.Entry<K, V>, Map<K, V>>().apply(block))

fun <E : Any> Builder.arrayList(
    default: ArrayList<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((ArrayList<E>) -> ArrayList<E>)? = null
) = IterablePropertyFactory.makeArrayList(IterablePropertyOptions(default, map, filter, sanitize))

fun <E : Any> Builder.arrayList(block: IterablePropertyOptions<E, ArrayList<E>>.() -> Unit) =
    IterablePropertyFactory.makeArrayList(IterablePropertyOptions<E, ArrayList<E>>().apply(block))

// -----------------------------------------------------
// Array is special one, we have to use inline & reified
// -----------------------------------------------------

inline fun <reified T> Builder.array(
    default: Array<T>? = null,
    noinline map: ((T) -> T)? = null,
    noinline filter: ((T) -> Boolean)? = null,
    noinline sanitize: ((Array<T>) -> Array<T>)? = null
) = makeArrayProperty(ArrayPropertyOptions(default, map, filter, sanitize))

inline fun <reified T> Builder.array(block: ArrayPropertyOptions<T>.() -> Unit) =
    makeArrayProperty(ArrayPropertyOptions<T>().apply(block))


// -----------------------------------------------------
// Nullable
// -----------------------------------------------------

fun <T> Builder.nullable(block: Builder.() -> Property<T>): NullableProperty<T> = NullableProperty(block.invoke(this))
fun <T> Builder.nullable(property: Property<T>): NullableProperty<T> = NullableProperty(property)

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

fun <E : Any> Builder.nullableCollection(
    default: Collection<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Collection<E>) -> Collection<E>)? = null
) = nullable(collection(default, map, filter, sanitize))

fun <E : Any> Builder.nullableCollection(block: IterablePropertyOptions<E, Collection<E>>.() -> Unit) =
    nullable(collection(block))

fun <E : Any> Builder.nullableList(
    default: List<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((List<E>) -> List<E>)? = null
) = nullable(list(default, map, filter, sanitize))

fun <E : Any> Builder.nullableList(block: IterablePropertyOptions<E, List<E>>.() -> Unit) =
    nullable(list(block))

fun <E : Any> Builder.nullableSet(
    default: Set<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((Set<E>) -> Set<E>)? = null
) = nullable(set(default, map, filter, sanitize))

fun <E : Any> Builder.nullableSet(block: IterablePropertyOptions<E, Set<E>>.() -> Unit) =
    nullable(set(block))

fun <K, V> Builder.nullableMap(
    default: Map<K, V>? = null,
    map: ((Map.Entry<K, V>) -> Map.Entry<K, V>)? = null,
    filter: ((Map.Entry<K, V>) -> Boolean)? = null,
    sanitize: ((Map<K, V>) -> Map<K, V>)? = null
) = nullable(map(default, map, filter, sanitize))

fun <K, V> Builder.nullableMap(block: IterablePropertyOptions<Map.Entry<K, V>, Map<K, V>>.() -> Unit) =
    nullable(map(block))

fun <E : Any> Builder.nullableArrayList(
    default: ArrayList<E>? = null,
    map: ((E) -> E)? = null,
    filter: ((E) -> Boolean)? = null,
    sanitize: ((ArrayList<E>) -> ArrayList<E>)? = null
) = nullable(arrayList(default, map, filter, sanitize))

fun <E : Any> Builder.nullableArrayList(block: IterablePropertyOptions<E, ArrayList<E>>.() -> Unit) =
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
