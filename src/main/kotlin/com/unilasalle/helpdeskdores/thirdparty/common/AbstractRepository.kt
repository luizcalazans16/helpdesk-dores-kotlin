package com.unilasalle.helpdeskdores.thirdparty.common

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import java.net.URI

abstract class AbstractRepository {

    protected fun newRequest(
        url: String,
        method: HttpMethod,
        httpHeaders: HttpHeaders
    ): RequestEntity.BodyBuilder {
        return RequestEntity.method(method, URI.create(url))
            .headers(httpHeaders)
    }

    protected open fun createHeaders(): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE)

        return headers
    }
}