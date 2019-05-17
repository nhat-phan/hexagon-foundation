package net.ntworld.hexagon.foundation.builder

internal object IterablePropertyFactory {
//    fun <T : Any> makeArray(options: IterablePropertyOptions<T, Array<T>>): IterableProperty<T, Array<T>> {
//        return IterableProperty(
//            options,
//            filterFn = { input, predicate ->
//                // val filtered = input.filter(predicate)
//                arrayOf()
//                // Array(filtered.size) { filtered[it] }
//                // filtered.toTypedArray()
//                // arrayOf()
//            },
//            mapFn = { input, transform ->
//                // val transformed = input.map(transform)
//                arrayOf()
//                // Array(transformed.size) { transformed[it] }
//                // transformed.toTypedArray()
//                // arrayOf()
//            }
//        )
//    }

    fun makeBooleanArray(options: IterablePropertyOptions<Boolean, BooleanArray>): IterableProperty<Boolean, BooleanArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                BooleanArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                BooleanArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeByteArray(options: IterablePropertyOptions<Byte, ByteArray>): IterableProperty<Byte, ByteArray> {
        return IterableProperty(
            options,
            filterFn = { input: ByteArray, predicate: (Byte) -> Boolean ->
                val filtered = input.filter(predicate)
                ByteArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: ByteArray, transform: (Byte) -> Byte ->
                val transformed = input.map(transform)
                ByteArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeShortArray(options: IterablePropertyOptions<Short, ShortArray>): IterableProperty<Short, ShortArray> {
        return IterableProperty(
            options,
            filterFn = { input: ShortArray, predicate: (Short) -> Boolean ->
                val filtered = input.filter(predicate)
                ShortArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: ShortArray, transform: (Short) -> Short ->
                val transformed = input.map(transform)
                ShortArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeIntArray(options: IterablePropertyOptions<Int, IntArray>): IterableProperty<Int, IntArray> {
        return IterableProperty(
            options,
            filterFn = { input: IntArray, predicate: (Int) -> Boolean ->
                val filtered = input.filter(predicate)
                IntArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: IntArray, transform: (Int) -> Int ->
                val transformed = input.map(transform)
                IntArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeLongArray(options: IterablePropertyOptions<Long, LongArray>): IterableProperty<Long, LongArray> {
        return IterableProperty(
            options,
            filterFn = { input: LongArray, predicate: (Long) -> Boolean ->
                val filtered = input.filter(predicate)
                LongArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: LongArray, transform: (Long) -> Long ->
                val transformed = input.map(transform)
                LongArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeFloatArray(options: IterablePropertyOptions<Float, FloatArray>): IterableProperty<Float, FloatArray> {
        return IterableProperty(
            options,
            filterFn = { input: FloatArray, predicate: (Float) -> Boolean ->
                val filtered = input.filter(predicate)
                FloatArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: FloatArray, transform: (Float) -> Float ->
                val transformed = input.map(transform)
                FloatArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeDoubleArray(options: IterablePropertyOptions<Double, DoubleArray>): IterableProperty<Double, DoubleArray> {
        return IterableProperty(
            options,
            filterFn = { input: DoubleArray, predicate: (Double) -> Boolean ->
                val filtered = input.filter(predicate)
                DoubleArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: DoubleArray, transform: (Double) -> Double ->
                val transformed = input.map(transform)
                DoubleArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeCharArray(options: IterablePropertyOptions<Char, CharArray>): IterableProperty<Char, CharArray> {
        return IterableProperty(
            options,
            filterFn = { input: CharArray, predicate: (Char) -> Boolean ->
                val filtered = input.filter(predicate)
                CharArray(filtered.size) { filtered[it] }
            },
            mapFn = { input: CharArray, transform: (Char) -> Char ->
                val transformed = input.map(transform)
                CharArray(transformed.size) { transformed[it] }
            }
        )
    }

//    fun <T : Any> makeList(options: IterablePropertyOptions<T, List<T>>): IterableProperty<T, List<T>> {
//        return IterableProperty(options) { input, predicate ->
//            input.filter(predicate)
//        }
//    }

}