package school.cactus.succulentshop.login.validation

import school.cactus.succulentshop.EmailValidator
import school.cactus.succulentshop.UsernameValidator
import school.cactus.succulentshop.Validator

class IdentifierValidator : Validator() {

    override fun isValid(field: String): Boolean {
        val emailValidator = EmailValidator()
        if (!emailValidator.isValid(field)) {
            error = emailValidator.getError()
            return UsernameValidator().isValid(field)
        }
        return true
    }

}