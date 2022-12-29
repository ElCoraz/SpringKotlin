package com.application.execute.config

import org.apache.catalina.Context
import org.apache.tomcat.util.http.Rfc6265CookieProcessor
import org.apache.tomcat.util.http.SameSiteCookies
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class TomcatConfiguration {
    @Bean
    fun sameSiteCookiesConfig(): TomcatContextCustomizer {
        return TomcatContextCustomizer { context: Context ->
            val cookieProcessor = Rfc6265CookieProcessor()
            // SameSite
            cookieProcessor.setSameSiteCookies(SameSiteCookies.LAX.value)
            context.cookieProcessor = cookieProcessor
        }
    }
}