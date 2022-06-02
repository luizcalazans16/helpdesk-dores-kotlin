package com.unilasalle.helpdeskdores.webservice.request

import com.unilasalle.helpdeskdores.business.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class RegisterUserRequest(
    @field:NotEmpty(message = "O nome deve ser informado")
    var name: String,

    @field:Email(message = "O e-mail deve ser válido")
    @EmailAvailable
    var email: String,

    @field:NotEmpty(message = "Uma senha deve ser informada")
    var password: String

)