package com.application.execute.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.sql.DataSource
import kotlin.jvm.Throws

/**********************************************************************************************************************/
@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    /*****************************************************************************************************************/
    @Autowired
    private lateinit var datasource: DataSource
    /*****************************************************************************************************************/
     @Throws(Exception::class)
     override fun configure(http: HttpSecurity): Unit {
         //http.csrf().disable().authorizeRequests()
         //        .antMatchers("/bootstrap/**", "/dist/**", "/plugins/**").permitAll()
         //        .anyRequest().authenticated()
         //        .and()
         //        .httpBasic()
         //        .and()
         //        .formLogin()
         //        .failureUrl("/login?error")
         //        .loginPage("/login")
         //        .defaultSuccessUrl("/")
         //        .permitAll()
         //        .and()
         //        .logout()
         //        .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
         //        .logoutSuccessUrl("/login")
         //        .permitAll()*/
    }
    /*****************************************************************************************************************/
     override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/",
                "/v3/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**")
    }
    /*****************************************************************************************************************/
    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        val userDetailsService = JdbcUserDetailsManager()
        userDetailsService.setDataSource(datasource)
        auth.userDetailsService(userDetailsService).passwordEncoder(BCryptPasswordEncoder())
        auth.jdbcAuthentication().dataSource(datasource)
    }
}
//**********************************************************************************************************************