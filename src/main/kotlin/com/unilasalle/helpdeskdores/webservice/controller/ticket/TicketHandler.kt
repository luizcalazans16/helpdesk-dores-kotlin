package com.unilasalle.helpdeskdores.webservice.controller.ticket

import com.unilasalle.helpdeskdores.business.service.TicketService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class TicketHandler(
    val ticketService: TicketService
) {

    @Transactional
    suspend fun register(request: ServerRequest): ServerResponse {
        val registeredTicket = ticketService.registerTicket()
        return ServerResponse.status(HttpStatus.CREATED).bodyValueAndAwait(registeredTicket)
    }
}