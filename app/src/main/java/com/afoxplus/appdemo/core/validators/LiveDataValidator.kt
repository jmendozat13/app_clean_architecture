package com.afoxplus.appdemo.core.validators

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias Predicate = (value: String?) -> Boolean

class LiveDataValidator(private val liveData: LiveData<String>) : Validator() {
    private val validationRules = mutableListOf<Predicate>()
    private val errorMessages = mutableListOf<String>()
    var error = MutableLiveData<String?>()

    /**
     * For checking if the liveData value matches the error condition set in the validation rule predicate
     * The livedata value is said to be valid when its value doesn't match an error condition set in the predicate
     * */
    override fun isValid(): Boolean {
        for (i in 0 until validationRules.size) {
            if (validationRules[i](liveData.value)) {
                emitErrorMessage(errorMessages[i])
                return false
            }
        }
        emitErrorMessage(null)
        return true
    }

    private fun emitErrorMessage(messageRes: String?) {
        error.value = messageRes
    }

    fun addRule(errorMsg: String, predicate: Predicate) {
        validationRules.add(predicate)
        errorMessages.add(errorMsg)
    }

}

class LiveDataValidatorResolver(private val validators: List<LiveDataValidator>) : Validator() {
    override fun isValid(): Boolean {
        for (validator in validators) {
            if (!validator.isValid()) return false
        }
        return true
    }
}