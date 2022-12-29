package com.application.execute.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.web.http.CookieSerializer
import org.springframework.session.web.http.DefaultCookieSerializer


@Configuration
class SpringSessionConfiguration {
    @Bean
    fun cookieSerializer(): CookieSerializer {
        val serializer = DefaultCookieSerializer()
        serializer.setCookieName("JSESSIONID")
        serializer.setDomainName("localhost")
        serializer.setCookiePath("/")
        serializer.setCookieMaxAge(3600)
        serializer.setUseHttpOnlyCookie(true)
        serializer.setUseSecureCookie(false)
        return serializer
    }
}