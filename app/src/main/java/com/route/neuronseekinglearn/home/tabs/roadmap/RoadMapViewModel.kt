package com.route.neuronseekinglearn.home.tabs.roadmap

import androidx.lifecycle.ViewModel
import com.route.neuronseekinglearn.common.SingleLiveEvent

class RoadMapViewModel : ViewModel() {
    val events = SingleLiveEvent<RoadMapEvent>()

    fun navigateToFrontEnd() {
        events.postValue(
            RoadMapEvent.NavigateToFrontEnd
        )
    }

    fun navigateToBackEnd() {
        events.postValue(
            RoadMapEvent.NavigateToBackEnd
        )
    }

    fun navigateToFullStack() {
        events.postValue(
            RoadMapEvent.NavigateToBackEnd
        )
    }

    fun navigateToAndroid() {
        events.postValue(
            RoadMapEvent.NavigateToBackEnd
        )
    }

    fun navigateToFlutter() {
        events.postValue(
            RoadMapEvent.NavigateToBackEnd
        )
    }

    fun navigateToDataScience() {
        events.postValue(
            RoadMapEvent.NavigateToDataScience
        )
    }

    fun navigateToPython() {
        events.postValue(
            RoadMapEvent.NavigateToPython
        )
    }
}