package com.unilasalle.helpdeskdores.webservice.controller.ticket

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class TicketRouter {

    companion object {
        const val PATH = "/api/v1/tickets"
        const val TAG = "Ticket"
    }

//    @RouterOperations(
//        RouterOperation(
//            path = PATH,
//            method = [RequestMethod.POST],
//            operation = Operation(
//                operationId = "register-ticket",
//                tags = [TAG],
//                requestBody = RequestBody(
//                    content =
//                )
//            )
//        )
//    )

    @Bean
    fun ticketRoutes(handler: TicketHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            PATH.nest {
                POST("", handler::register)
                GET("/{ID}", handler::getById)
            }
        }
    }
}