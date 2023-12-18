package oyune.soptracker.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import oyune.soptracker.user.entity.User

interface UserRepository : JpaRepository<User, Long> {

    fun findByUserNum(userNum: Long): User?

}