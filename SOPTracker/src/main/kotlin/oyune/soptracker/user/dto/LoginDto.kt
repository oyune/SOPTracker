package oyune.soptracker.user.dto

data class UserLoginRequestDto(
        /**
         * 사원 이름
         */
        val username: String,
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

data class UserLoginResponseDto(
        /**
         * 실행 후 에러 발생시 메시지
         */
        val message: String,
)