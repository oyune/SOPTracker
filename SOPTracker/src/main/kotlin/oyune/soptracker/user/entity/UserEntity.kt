package oyune.soptracker.user.entity

import jakarta.persistence.*
import oyune.soptracker.enums.DepType

@Entity(name="user")
class UserEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userNum: Long,

        @Column(nullable = false, unique = false)
        val userName: String,

        @Column(nullable = false)
        val password: String,

        @Column(nullable = false, unique = false)
        @Enumerated(EnumType.STRING)
        val depName: DepType,
){}