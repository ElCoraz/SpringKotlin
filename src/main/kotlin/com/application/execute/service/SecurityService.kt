package com.application.execute.service

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

/**********************************************************************************************************************/
@Service
class SecurityService {
    /******************************************************************************************************************/
    fun isAdmin(): Boolean {
        var result = false

        val authentication = SecurityContextHolder.getContext().authentication

        for (permission in authentication.authorities as Collection<SimpleGrantedAuthority>) {
            if (permission.authority == "ADMIN") {
                result = true
                break
            }
        }

        return result
    }
}