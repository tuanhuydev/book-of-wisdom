package ex01

/**
 * You are implementing a Repository Layer with a requirement for Audit Logging. Instead of manually adding a log statement to every single repository method, use a delegating class.
 *
 * Refactor the AuditUserRepository below using the by keyword so it implements UserRepository by delegating to baseRepository. You should only need to override the save method to add your log; let the baseRepository handle delete and findById automatically.
 *
 * Kotlin
 * interface UserRepository {
 *     fun save(user: String)
 *     fun delete(user: String)
 *     fun findById(id: String): String
 * }
 *
 * class SqlUserRepository : UserRepository {
 *     override fun save(user: String) = println("Saving $user to SQL")
 *     override fun delete(user: String) = println("Deleting $user from SQL")
 *     override fun findById(id: String): String = "User-$id"
 * }
 *
 * // TODO: Refactor this class header and body
 * class AuditUserRepository(private val baseRepository: UserRepository) : UserRepository {
 *     override fun save(user: String) {
 *         println("Audit: User $user is being saved")
 *         baseRepository.save(user)
 *     }
 *
 *     // I don't want to manually implement delete() or findById()!
 * }
 * How would you change the class declaration of AuditUserRepository to use the by keyword?
 */

interface UserRepository {
    fun save(user: String)
    fun delete(user: String)
    fun findById(id: String): String
}

class SqlUserRepository : UserRepository {
    override fun save(user: String) = println("Saving $user to SQL")
    override fun delete(user: String) = println("Deleting $user from SQL")
    override fun findById(id: String): String = "User-$id"
}

// TODO: Refactor this class header and body
class AuditUserRepository(private val baseRepository: UserRepository) : UserRepository by SqlUserRepository() {
    override fun save(user: String) {
        println("Audit: User $user is being saved")
        baseRepository.save(user)
    }

}