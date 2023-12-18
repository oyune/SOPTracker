package oyune.soptracker.user.service

import org.springframework.stereotype.Service
import oyune.soptracker.user.dto.UserDeleteRequestDto
import oyune.soptracker.user.dto.UserLoginRequestDto
import oyune.soptracker.user.dto.UserRegistrationRequestDto
import oyune.soptracker.user.entity.User
import oyune.soptracker.user.repository.UserRepository

@Service
class UserService (private val userRepository: UserRepository
) {
    /**
     * 사용자 로그인을 위해 입력받은 사원 번호로 사용자를 검색하고, 비밀번호 일치 여부를 판단한다.
     * @param data 로그인하려는 사원의 사원 정보
     * @return 로그인한 사용자 정보
     * @throws IllegalStateException 로그인에 실패한 경우
     */
    fun login(data: UserLoginRequestDto) : User {
        val userNum = data.userNum
        val password = data.password
        // 사원 번호를 통한 사원 검색
        val user = userRepository.findByUserNum(userNum) ?: error{"사원 번호를 확인해주세요."}
        //비밀번호 일치 여부 확인
        check(password == user.password) {"비밀번호를 확인해주세요."}
        return user
    }

    /**
     * 사원 등록을 위해 관리자 인증을 하고, 사원을 등록한다.
     * @param adminNum 관리자 정보
     * @param dataToCreate 등록할 사원 정보
     * @return 등록된 사원 정보
     * @throws IllegalStateException 관리자 인증에 실패한 경우
     */
    fun createUser(adminNum: UserLoginRequestDto, dataToCreate: UserRegistrationRequestDto) : User {
        val admin = login(adminNum)
        // 관리자 여부 확인
        check(admin.depName.equals("Executives")) {"회원 등록 권한이 없습니다."}
        // 사원 등록
        return userRepository.save(
                User(
                        userName = dataToCreate.userName,
                        userNum = dataToCreate.userNum,
                        password = dataToCreate.password,
                        depName = dataToCreate.depName,
                )
        )
    }

    /**
     * 사원 삭제를 위해 관리자 인증을 하고, 사원을 삭제한다.
     * @param adminNum 관리자 정보
     * @param dataToDelete 삭제할 사원 정보
     * @return 삭제된 사원 정보
     * @throws IllegalStateException 관리자 인증에 실패한 경우
     */
    fun deleteUser(adminNum: UserLoginRequestDto, dataToDelete: UserDeleteRequestDto){
        val admin = login(adminNum)
        // 관리자 여부 확인
        check(admin.depName.equals("Executives")) {"회원 삭제 권한이 없습니다."}
        // 사원 삭제
        return userRepository.deleteById(dataToDelete.userNum)
    }
}