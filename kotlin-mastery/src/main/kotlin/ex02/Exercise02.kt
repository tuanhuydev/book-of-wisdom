package ex02

/**
 * [Problem 8] - Phase 1: The Kotlin Core
 *
 * Topic: Delegate Properties (by) 🤝
 * Theory: Kotlin allows you to outsource the getter/setter logic of a property to a separate object called a delegate, which is useful for cross-cutting concerns like lazy loading, logging, or validation.
 *
 * Challenge:
 * In backend development, we often want to avoid expensive setup costs until a resource is actually needed (e.g., establishing a connection to a secondary heavy-duty reporting database).
 *
 * We have a DatabaseConnection that takes 2 seconds to initialize. Implement the ReportService so that the connection is only created the first time it is accessed, and ensure it is thread-safe.
 *
 * Kotlin
 * class DatabaseConnection {
 *     init {
 *         println("Connecting to Heavy Database... (Expensive!)")
 *     }
 *     fun query() = "Data from heavy DB"
 * }
 *
 * class ReportService {
 *     // TODO: Use a standard Kotlin delegate to make this lazy and thread-safe
 *     val connection: DatabaseConnection = ___
 *
 *     fun generateReport() {
 *         println("Starting report...")
 *         println(connection.query())
 *     }
 * }
 *
 * fun runExercise14() {
 *     val service = ReportService()
 *     println("Service initialized.")
 *     service.generateReport() // Connection should happen here, not before
 * }
 * How would you use a delegate to ensure connection is only initialized when generateReport is called?
 */

class DatabaseConnection {
    init {
        println("Connecting to Heavy Database... (Expensive!)")
    }

    fun query() = "Data from heavy DB"
}

class ReportService {
    // TODO: Use a standard Kotlin delegate to make this lazy and thread-safe
    val connection: DatabaseConnection by lazy { DatabaseConnection() }

    fun generateReport() {
        println("Starting report...")
        println(connection.query())
    }
}

fun runExercise14() {
    val service = ReportService()
    println("Service initialized.")
    service.generateReport() // Connection should happen here, not before
}