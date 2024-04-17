package com.route.neuronseekinglearn.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.neuronseekinglearn.common.SingleLiveEvent
import com.route.neuronseekinglearn.firestore.UsersDao
import com.route.neuronseekinglearn.message
import com.route.neuronseekinglearn.model.User
import com.route.neuronseekinglearn.sessionProvider

class LoginViewModel : ViewModel() {
    val MessageLiveData = SingleLiveEvent<message>()
    val isLoading = MutableLiveData<Boolean>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val emailError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()

    val events = SingleLiveEvent<LoginEvent>()

    val auth = Firebase.auth

    fun login() {
        if (!ValidForm()) return
        isLoading.value = true

        auth.signInWithEmailAndPassword(
            email.value!!,
            password.value!!
        )
            .addOnCompleteListener { Task ->
                isLoading.value = false
                if (Task.isSuccessful) {
                    getUserFromFirestore(Task.result.user?.uid)
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
            LoginEvent.NavigateToHome
        )
    }

    private fun getUserFromFirestore(uid: String?) {
        UsersDao.getUser(uid) { Task ->
            isLoading.value = false
            if (Task.isSuccessful) {
                val user = Task.result.toObject(User::class.java)
                sessionProvider.user = user
                MessageLiveData.postValue(
                    message(
                        message = "User Login Succesfull",
                        posActionName = "ok",
                        OnPosAction = {
                            events.postValue(LoginEvent.NavigateToHome)

                            // Navigat To Home
                        },
                        IsCancelable = false
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

    fun ValidForm(): Boolean {
        var isValid = true

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

        return isValid
    }


    fun navigateToRegister() {
        events.postValue(LoginEvent.NavigateToRegister)
    }

}