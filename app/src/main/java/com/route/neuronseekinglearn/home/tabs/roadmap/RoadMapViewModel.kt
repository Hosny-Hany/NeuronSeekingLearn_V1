package com.route.neuronseekinglearn.home.tabs.roadmap

import androidx.lifecycle.ViewModel
import com.route.neuronseekinglearn.common.SingleLiveEvent

class RoadMapViewModel : ViewModel() {
    val events = SingleLiveEvent<RoadMapEvent>()

    fun navigateToHome() {
        events.postValue(
            RoadMapEvent.NavigateToHome
        )
    }
}