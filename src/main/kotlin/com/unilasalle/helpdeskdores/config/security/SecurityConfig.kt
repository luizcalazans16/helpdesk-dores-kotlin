package com.unilasalle.helpdeskdores.config.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http
            ?.cors()
            ?.and()
            ?.csrf()?.disable()
            ?.authorizeRequests()
            ?.antMatchers(HttpMethod.POST, "**/login")?.permitAll()
            ?.anyRequest()
            ?.authenticated()

        http?.oauth2ResourceServer()?.jwt()
    }
}