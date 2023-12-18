package oyune.soptracker.user.dto

data class UserDeleteRequestDto(
        /**
         * 사원 번호
         */
        val userNum: Long,

        /**
         * 비밀번호
         */
        val password: String,

)

data class UserDeleteResponseDto(
        /**
         * 에러 메시지
         */
        val message: String,

)