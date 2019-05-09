package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

/**
 * Create Port:
 *
 * makePort {
 *   builder = MapBuilder()
 *   validator = argument + multiTenancy + multiTenancyUser
 *   factory = CreateUserArgumentFactory()
 * } handle {
 * }
 *
 * Using Port:
 *
 * val result = API.createPort use jwt+session {
 *   username = "",
 *   email = ""
 * }
 *
 */

interface PortUsage<B : ArgumentBuilder, out T> {
    infix fun use(director: ArgumentBuildDirector<B>): PortUsage<B, T>

    infix fun with(block: B.() -> Unit): Deferred<T>
}

interface API {
    val createUser: PortUsage<ArgumentBuilder, String>
}

class Jwt() : ArgumentBuildDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun test() {
    val api: API = "" as API
    val result = api.createUser use Jwt() + Jwt() with {
        setContextEnvironment("test", "id")
    }

}