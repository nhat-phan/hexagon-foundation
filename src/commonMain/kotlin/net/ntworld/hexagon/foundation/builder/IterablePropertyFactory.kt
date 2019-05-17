package net.ntworld.hexagon.foundation.builder

internal object IterablePropertyFactory {
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
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                ByteArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                ByteArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeShortArray(options: IterablePropertyOptions<Short, ShortArray>): IterableProperty<Short, ShortArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                ShortArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                ShortArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeIntArray(options: IterablePropertyOptions<Int, IntArray>): IterableProperty<Int, IntArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                IntArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                IntArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeLongArray(options: IterablePropertyOptions<Long, LongArray>): IterableProperty<Long, LongArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                LongArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                LongArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeFloatArray(options: IterablePropertyOptions<Float, FloatArray>): IterableProperty<Float, FloatArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                FloatArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                FloatArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeDoubleArray(options: IterablePropertyOptions<Double, DoubleArray>): IterableProperty<Double, DoubleArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                DoubleArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                DoubleArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun makeCharArray(options: IterablePropertyOptions<Char, CharArray>): IterableProperty<Char, CharArray> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                val filtered = input.filter(predicate)
                CharArray(filtered.size) { filtered[it] }
            },
            mapFn = { input, transform ->
                val transformed = input.map(transform)
                CharArray(transformed.size) { transformed[it] }
            }
        )
    }

    fun <E : Any> makeCollection(options: IterablePropertyOptions<E, Collection<E>>): IterableProperty<E, Collection<E>> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                input.filter(predicate)
            },
            mapFn = { input, transform ->
                input.map(transform)
            }
        )
    }

    fun <E : Any> makeList(options: IterablePropertyOptions<E, List<E>>): IterableProperty<E, List<E>> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                input.filter(predicate)
            },
            mapFn = { input, transform ->
                input.map(transform)
            }
        )
    }

    fun <E : Any> makeSet(options: IterablePropertyOptions<E, Set<E>>): IterableProperty<E, Set<E>> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                input.filter(predicate).toSet()
            },
            mapFn = { input, transform ->
                input.map(transform).toSet()
            }
        )
    }

    fun <K, V> makeMap(options: IterablePropertyOptions<Map.Entry<K, V>, Map<K, V>>): IterableProperty<Map.Entry<K, V>, Map<K, V>> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                input.filter(predicate)
            },
            mapFn = { input, transform ->
                val transformed: List<Map.Entry<K, V>> = input.map(transform)
                val result = mutableMapOf<K, V>()
                for (item in transformed) {
                    result[item.key] = item.value
                }
                result
            }
        )
    }

}