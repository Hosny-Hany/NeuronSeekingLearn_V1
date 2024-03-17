package com.route.neuronseekinglearn.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.neuronseekinglearn.common.SingleLiveEvent
import com.route.neuronseekinglearn.firestore.UsersDao
import com.route.neuronseekinglearn.message
import com.route.neuronseekinglearn.model.User
import com.route.neuronseekinglearn.sessionProvider

class RegisterViewModel : ViewModel() {
    val MessageLiveData = SingleLiveEvent<message>()
    val isLoading = MutableLiveData<Boolean>()
    val events = SingleLiveEvent<RegisterEvent>()

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
                    insertUsertoFirebase(Task.result.user?.uid)
                    navigateToHome()
                } else {
                    //showError
                    MessageLiveData.postValue(
                        message(
                            message = Task.exception?.localizedMessage
                        )
                    )
                }
            }
    }

    private fun navigateToHome() {
        events.postValue(
            RegisterEvent.NavigateToHome
        )
    }

    private fun insertUsertoFirebase(uid: String?) {
        val user = User(
            id = uid,
            userName = username.value,
            email = email.value
        )
        UsersDao.createUser(user) { Task ->
            if (Task.isSuccessful) {
                isLoading.value = false
                MessageLiveData.postValue(
                    message(
                        message = "User Registed Succesfull",
                        posActionName = "ok",
                        OnPosAction = {
                            sessionProvider.user = user
                            events.postValue(RegisterEvent.NavigateToHome)
                            //Save user Id
                            // Navegat To Home
                        }
                    )
                )

            } else {
                MessageLiveData.postValue(
                    message(
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

    fun navigateToLogin() {
        events.postValue(RegisterEvent.NavigateToLogin)
    }
}