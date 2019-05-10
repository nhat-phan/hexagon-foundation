package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

typealias PortAsync<Builder, Result> = Port<Builder, Deferred<Result>>