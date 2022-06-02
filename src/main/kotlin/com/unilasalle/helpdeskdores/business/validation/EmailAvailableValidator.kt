package com.unilasalle.helpdeskdores.business.validation

import com.unilasalle.helpdeskdores.business.service.UserService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


class EmailAvailableValidator(
    var userService: UserService
) : ConstraintValidator<EmailAvailable, String> {


    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }
        return userService.emailAvailable(value)
    }
}
