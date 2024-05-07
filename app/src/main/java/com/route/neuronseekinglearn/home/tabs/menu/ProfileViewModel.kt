package com.route.neuronseekinglearn.home.tabs.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    val username = MutableLiveData<String>()
    val email = MutableLiveData<String>()

}