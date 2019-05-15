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

//    fun <T : Any> makeList(options: IterablePropertyOptions<T, List<T>>): IterableProperty<T, List<T>> {
//        return IterableProperty(options) { input, predicate ->
//            input.filter(predicate)
//        }
//    }

}