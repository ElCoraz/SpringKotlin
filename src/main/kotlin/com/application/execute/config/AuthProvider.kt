package com.application.execute.config

import com.application.execute.model.Users
import com.application.execute.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.util.*

/**********************************************************************************************************************/
@Component
class AuthProvider: AuthenticationProvider{
    /******************************************************************************************************************/
    @Autowired
    private lateinit var userRepository: UsersRepository
    /******************************************************************************************************************/
    override fun authenticate(authentication: Authentication): UsernamePasswordAuthenticationToken {
        val username: String = authentication.name
        val password: String = authentication.credentials.toString()

        val user: Users = userRepository.findById(username).get()

        if (!user.password.equals(password)) {
            throw BadCredentialsException ("Wrong username or password!")
        }

        return UsernamePasswordAuthenticationToken(username, password, Collections.singleton(SimpleGrantedAuthority("WEB_USER")));
    }
    /******************************************************************************************************************/
    override fun supports(authentication: Class<*>?): Boolean {
        return authentication === UsernamePasswordAuthenticationToken::class.java
    }
}