package com.application.execute.service

import com.application.execute.security.data.Roles
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service

@Service
class SecurityService {
    /******************************************************************************************************************/
    fun isAdmin(): Boolean {
        var result = false

        val authentication = SecurityContextHolder.getContext().authentication

        for (permission in authentication.authorities as Collection<SimpleGrantedAuthority>) {
            if (permission.authority.toString() == Roles.ADMIN.toString()) {
                result = true
                break
            }
        }

        return result
    }
    /******************************************************************************************************************/
    fun getUsername(): String {
        val securityContextHolder = SecurityContextHolder.getContext()

        if (securityContextHolder.authentication != null) {
            return (securityContextHolder.authentication.principal as User).username
        }
        return "";
    }
}