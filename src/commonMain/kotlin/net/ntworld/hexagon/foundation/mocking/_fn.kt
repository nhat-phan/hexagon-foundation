package net.ntworld.hexagon.foundation.mocking

fun mock(instance: ManualMock, block: MockBuilder.() -> Unit) = MockBuilder(instance).apply(block)