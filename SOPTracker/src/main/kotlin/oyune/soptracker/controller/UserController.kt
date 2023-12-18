package oyune.soptracker.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController {
    /**
     * 사원 등록 api
     */
    @PostMapping("")
    fun register()
}