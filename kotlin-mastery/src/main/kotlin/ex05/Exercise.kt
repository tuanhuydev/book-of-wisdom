package ex05

import kotlin.math.pow

class UserSession(var currentUser: String?)

fun greet(session: UserSession): String {
   val currentUser = session.currentUser
    if (currentUser != null) {
        return "Hello, $currentUser"
    }
    return "Hello, Guest"
}

data class Cart(val items: MutableList<String>, val ownerName: String)

fun renameCart(cart: Cart, newOwner: String): Cart {
    val newItems = cart.items.toMutableList()
    return cart.copy(items = newItems, ownerName = newOwner)
}

fun demo() {
    val original = Cart(mutableListOf("apple", "banana"), "Huy")
    val renamed = renameCart(original, "Nam")

    renamed.items.add("cherry")
    print(original)

}

sealed class Shape

data class Circle(val radius: Double) : Shape()
data class Rectangle(val width: Double, val height: Double) : Shape()
data class Triangle(val base: Double, val height: Double) : Shape()
object Point : Shape()

fun area(shape: Shape): Double {
    return when (shape) {
        is Circle -> shape.radius.pow(2) * Math.PI
        is Rectangle -> shape.width * shape.height
        is Triangle -> shape.base * shape.height / 2
        Point -> 0.toDouble()
    }
}

open class Vehicle(val name: String)
class Car(name: String) : Vehicle(name)

fun Vehicle.describe(): String = "Vehicle: $name"
fun Car.describe(): String = "Car: $name"

fun printInfo(v: Vehicle) {
    println(v.describe())
}

fun main(): String {
    val myCar: Car = Car("Tesla")
    loadPortFromEnv().run {
        return if (this == null) {
            "Port: default"
        } else {
            "Port: $this"
        }
    }
}


class Config(var host: String, var port: Int, var debug: Boolean)

fun buildConfig(): Config {
    return Config("Default", 0, false).apply {
        this.host = "localhost";
        this.port = 8080
        this.debug = true
    }
}

fun logConfig(config: Config): Config {
    return config.also {
        print("[CONFIG]: ${config.host}:${config.port} --debug=${config.debug}")
    }
}

fun loadPortFromEnv(): Int? {}