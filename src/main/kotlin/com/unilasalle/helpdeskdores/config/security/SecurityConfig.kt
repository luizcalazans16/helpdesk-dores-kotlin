package com.unilasalle.helpdeskdores.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var restSecProps: SecurityProperties

    @Autowired
    private lateinit var tokenAuthenticationFilter: SecurityFilter

    override fun configure(http: HttpSecurity?) {
        http?.cors()?.configurationSource(corsConfigurationSource())?.and()?.csrf()?.disable()?.formLogin()?.disable()
            ?.httpBasic()?.disable()?.exceptionHandling()?.authenticationEntryPoint(restAuthenticationEntryPoint())
            ?.and()?.authorizeRequests()
            ?.antMatchers(restSecProps.allowedPublicApis.toString())
            ?.permitAll()
            ?.antMatchers(HttpMethod.OPTIONS, "/**")?.permitAll()?.anyRequest()?.authenticated()?.and()
            ?.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}