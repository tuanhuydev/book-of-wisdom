package ex03


/**
 * [Problem 9] - Phase 1: The Kotlin Core
 *
 * Topic: Observable Properties (Delegates.observable) 🧐
 * Theory: This delegate acts as a "hook" that runs after a value is set. It is perfect for side effects like invalidating a cache or triggering an alert when a threshold is crossed.
 *
 * Challenge:
 * You are maintaining a Rate Limiter Service. You have a property requestLimit that dictates how many requests per second the system allows.
 *
 * Implement the logic inside the observable block so that:
 *
 * Every time the limit changes, it calls the syncWithRedis() helper function.
 *
 * If the new limit is more than double the old limit, it also calls the triggerSecurityAlert() function.
 *
 * Kotlin
 * import kotlin.properties.Delegates
 *
 * class RateLimiter {
 *     var requestLimit: Int by Delegates.observable(100) { prop, old, new ->
 *         // TODO: Implement the logic here
 *     }
 *
 *     private fun syncWithRedis(value: Int) {
 *         println("Syncing new limit $value to Redis...")
 *     }
 *
 *     private fun triggerSecurityAlert(old: Int, new: Int) {
 *         println("ALERT: Sudden limit spike from $old to $new!")
 *     }
 * }
 *
 * fun runExercise15_Actual() {
 *     val limiter = RateLimiter()
 *     limiter.requestLimit = 150 // Should only sync with Redis
 *     limiter.requestLimit = 400 // Should sync with Redis AND trigger alert
 * }
 */

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class RateLimiter {
    var requestLimit: Int by Delegates.observable(100) { prop, old, new ->
        // TODO: Implement the logic here
        syncWithRedis(new)
        if (new >= 2 * old) {
            triggerSecurityAlert(old, new)
        }

    }

    private fun syncWithRedis(value: Int) {
        println("Syncing new limit $value to Redis...")
    }

    private fun triggerSecurityAlert(old: Int, new: Int) {
        println("ALERT: Sudden limit spike from $old to $new!")
    }
}

fun runExercise15() {
    val limiter = RateLimiter()
    limiter.requestLimit = 150 // Should only sync with Redis
    limiter.requestLimit = 400 // Should sync with Redis AND trigger alert
}