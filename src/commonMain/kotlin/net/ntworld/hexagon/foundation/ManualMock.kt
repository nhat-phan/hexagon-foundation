//package net.ntworld.hexagon.foundation
//
//import kotlin.reflect.KFunction
//
//open class ManualMock {
//    operator fun invoke(block: ManualMockBuilder.() -> Unit) {}
//
//    fun verify(block: ManualMockVerifyBuilder.() -> Unit) {}
//
//    fun <R, T> implement(func: KFunction<R>, vararg params: Any): T {
//        return "" as T
//    }
//}
//
//
//class ManualMockBuilder {
//    infix fun <R> KFunction<R>.callFake(implementation: (params: List<String>) -> R): R {
//        // this.name
//        return implementation(listOf())
//    }
//
//    infix fun <R> KFunction<R>.willReturns(block: () -> R): R {
//        return block()
//    }
//}
//
//class ManualMockVerifyBuilder {
////    infix fun <R> KFunction<R>.invoke(block: ManualMockVerifyPropertyBuilder.() -> Unit) {
////
////    }
//}
//
//// ---------------------------------------------
//
//interface UserRepository {
//    fun createUser(): Boolean
//}
//
//class UserRepositoryMock : ManualMock(), UserRepository {
//    override fun createUser(): Boolean {
//        return implement(UserRepository::createUser)
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//}
//
//fun test() {
//    /**
//     * mocking(userRepository) {
//     *   userRepository::createUser callFake { params ->
//     *     val x = params.get(1)
//     *
//     *     true
//     *   }
//     * }
//     *
//     * verify(userRepository) {
//     *
//     * }
//     */
//    val userRepositoryMock = UserRepositoryMock()
//    userRepositoryMock {
//        userRepositoryMock::createUser callFake { params ->
//            val x = params.get(1)
//
//            true
//        }
//
//        ::test willReturns {
//            1
//        }
//    }
//
////    userRepositoryMock.verify {
////        userRepositoryMock::createUser {
////            called = 2
////            with { params ->
////                val (_, name, _) = params
////
////                name === "test"
////            }
////        }
////    }
//}
