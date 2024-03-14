package com.route.neuronseekinglearn.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.neuronseekinglearn.ChatAppError

class RegisterViewModel : ViewModel() {
    val ErrorLiveData = MutableLiveData<ChatAppError>()
    val isLoading = MutableLiveData<Boolean>()
    val username = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordconfirm = MutableLiveData<String>()
    val usernameError = MutableLiveData<String?>()
    val emailError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()
    val passwordconfirmError = MutableLiveData<String?>()

    val auth = Firebase.auth

    fun register() {
        if (!ValidForm()) return
        isLoading.value = true
        auth.createUserWithEmailAndPassword(
            email.value!!,
            password.value!!
        )
            .addOnCompleteListener { Task ->
                isLoading.value = false
                if (Task.isSuccessful) {
                    ErrorLiveData.postValue(
                        ChatAppError(
                            message = Task.result.user?.uid
                        )
                    )

                } else {
                    //showError
                    ErrorLiveData.postValue(
                        ChatAppError(
                            message = Task.exception?.localizedMessage
                        )
                    )
                }
            }
    }

    private fun ValidForm(): Boolean {
        var isValid = true
        if (username.value.isNullOrBlank()) {
            usernameError.postValue("userNameNotValid")
            isValid = false
        } else {
            usernameError.postValue(null)
        }
        if (email.value.isNullOrBlank()) {
            emailError.postValue("EmailNotValid")
            isValid = false
        } else {
            emailError.postValue(null)
        }
        if (password.value.isNullOrBlank()) {
            passwordError.postValue("PasswordNotValid")
            isValid = false
        } else {
            passwordError.postValue(null)
        }
        if (passwordconfirm.value != password.value) {
            passwordconfirmError.postValue("PasswordconfNotValid")
            isValid = false
        } else {
            passwordconfirmError.postValue(null)
        }
        return isValid
    }
}