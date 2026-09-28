import ex05.UserSession
import ex05.demo
import ex05.greet


fun main(args: Array<String>) {
    val userSession = UserSession(null)
    print(greet(userSession))
    demo()
}