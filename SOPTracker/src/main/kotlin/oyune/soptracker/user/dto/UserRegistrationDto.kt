package oyune.soptracker.user.dto

data class UserRegistrationRequestDto(
        /**
         * 사원 이름
         */
        val userName: String,
        /**
         * 사원 번호
         */
        val userNum: Long,
        /**
         * 비밀번호
         */
        val password: String,
        /**
         * 부서명
         */
        val depName: String,
)

data class UserRegistrationResponseDto(
        /**
         * 에러 메시지
         */
        val message: String,
)