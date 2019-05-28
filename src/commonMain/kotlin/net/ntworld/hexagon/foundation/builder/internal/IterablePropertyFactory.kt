package net.ntworld.hexagon.foundation.builder.internal

internal object IterablePropertyFactory {
    fun makeBooleanArray(options: IterablePropertyOptionsImpl<Boolean, BooleanArray>): IterableProperty<Boolean, BooleanArray> {
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

    fun makeByteArray(options: IterablePropertyOptionsImpl<Byte, ByteArray>): IterableProperty<Byte, ByteArray> {
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

    fun makeShortArray(options: IterablePropertyOptionsImpl<Short, ShortArray>): IterableProperty<Short, ShortArray> {
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

    fun makeIntArray(options: IterablePropertyOptionsImpl<Int, IntArray>): IterableProperty<Int, IntArray> {
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

    fun makeLongArray(options: IterablePropertyOptionsImpl<Long, LongArray>): IterableProperty<Long, LongArray> {
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

    fun makeFloatArray(options: IterablePropertyOptionsImpl<Float, FloatArray>): IterableProperty<Float, FloatArray> {
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

    fun makeDoubleArray(options: IterablePropertyOptionsImpl<Double, DoubleArray>): IterableProperty<Double, DoubleArray> {
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

    fun makeCharArray(options: IterablePropertyOptionsImpl<Char, CharArray>): IterableProperty<Char, CharArray> {
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

    fun <E> makeCollection(options: IterablePropertyOptionsImpl<E, Collection<E>>): IterableProperty<E, Collection<E>> {
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

    fun <E> makeList(options: IterablePropertyOptionsImpl<E, List<E>>): IterableProperty<E, List<E>> {
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

    fun <E> makeSet(options: IterablePropertyOptionsImpl<E, Set<E>>): IterableProperty<E, Set<E>> {
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

    fun <K, V> makeMap(options: IterablePropertyOptionsImpl<Map.Entry<K, V>, Map<K, V>>): IterableProperty<Map.Entry<K, V>, Map<K, V>> {
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

    fun <E> makeArrayList(options: IterablePropertyOptionsImpl<E, ArrayList<E>>): IterableProperty<E, ArrayList<E>> {
        return IterableProperty(
            options,
            filterFn = { input, predicate ->
                ArrayList(input.filter(predicate))
            },
            mapFn = { input, transform ->
                ArrayList(input.map(transform))
            }
        )
    }
}