package school.cactus.succulentshop.utils

import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.Validator

fun TextInputLayout.validate(validator: Validator) {
    val res = validator.isValid(editText!!.text.toString())
    if (validator.getError() != Validator.SUCCESS && !res) error =
        this.context.resources.getString(validator.getError())
    isErrorEnabled = !res
}