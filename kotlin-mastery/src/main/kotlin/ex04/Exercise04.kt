package ex04

/**
 * Challenge:
 * In our Order Management System, the stockQuantity of an item should never drop below zero. If an update would result in a negative number, the system must reject the update entirely.
 *
 * Implement the vetoable delegate for stockQuantity.
 *
 * Kotlin
 * import kotlin.properties.Delegates
 *
 * class WarehouseItem(initialStock: Int) {
 *     // TODO: Use Delegates.vetoable. Initial value is initialStock.
 *     // If the 'new' value is less than 0, print a rejection message and return false.
 *     var stockQuantity: Int = ___
 * }
 *
 * fun runExercise16() {
 *     val item = WarehouseItem(10)
 *
 *     item.stockQuantity = 5
 *     println("Stock is: ${item.stockQuantity}") // Should be 5
 *
 *     item.stockQuantity = -2 // This should be VETOED
 *     println("Stock is: ${item.stockQuantity}") // Should still be 5
 * }
 * How would you define the vetoable delegate to enforce this business rule?
 */