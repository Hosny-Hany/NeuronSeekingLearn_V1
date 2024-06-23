package com.route.neuronseekinglearn.home.tabs.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.route.neuronseekinglearn.common.SingleLiveEvent

class ProfileViewModel : ViewModel() {
    val events = SingleLiveEvent<ProfileEvent>()

    fun navigateToHome() {
        events.postValue(
            ProfileEvent.NavigateToHome
        )
    }

    val username = MutableLiveData<String>()
    val email = MutableLiveData<String>()

}