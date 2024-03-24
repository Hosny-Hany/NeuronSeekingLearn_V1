package com.route.neuronseekinglearn.home.tabs.home

import androidx.lifecycle.ViewModel
import com.route.neuronseekinglearn.common.SingleLiveEvent

class HomeViewModel:ViewModel() {
    val events = SingleLiveEvent<HomeEvents>()

     fun navigateToRoadMaps(){
        events.postValue(
            HomeEvents.NavigateToRoadMaps
        )
    }

     fun navigateToChatBot(){
        events.postValue(
            HomeEvents.NavigateToChatBot
        )
    }

     fun navigateToChooseTrack(){
        events.postValue(
            HomeEvents.NavigateToChooseTrack
        )
    }

}