package com.application.execute.controller

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import springfox.documentation.annotations.ApiIgnore
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
/**********************************************************************************************************************/
@ApiIgnore
@Controller
@RequestMapping("logout")
class LogoutController {
    /******************************************************************************************************************/
    @GetMapping("/logout")
    fun index(request: HttpServletRequest?, response: HttpServletResponse?): String {
        val authentication: Authentication? = SecurityContextHolder.getContext().authentication
        if (authentication != null) {
            SecurityContextLogoutHandler().logout(request, response, authentication)
        }
        return "/index"
    }
}