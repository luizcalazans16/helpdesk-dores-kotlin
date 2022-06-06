package com.unilasalle.helpdeskdores.thirdparty.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


@Configuration
class RestTemplateConfig(
    @Value("\${restclient.readtimeout}")
    private val readTimeout: Int,
    @Value("\${restclient.connecttimeout}")
    private val connectTimeout: Int

) {
    @Bean
    fun restTemplate(
    ): RestTemplate? {
        val restTemplate: RestTemplate = RestTemplateBuilder()
            .build()
        restTemplate.requestFactory = clientHttpRequestFactory()
        return restTemplate
    }

    fun clientHttpRequestFactory(): ClientHttpRequestFactory {
        val factory = HttpComponentsClientHttpRequestFactory()
        factory.setReadTimeout(readTimeout)
        factory.setConnectTimeout(connectTimeout)
        return factory
    }
}