package com.route.neuronseekinglearn.home.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentHomeBinding
import com.route.neuronseekinglearn.home.tabs.chatboat.ChatBoatFragment
import com.route.neuronseekinglearn.home.tabs.roadmap.RoadMapFragment

class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        initViews()
        println("View Mod")
    }

    private fun initViews() {
        viewBinding.viewModel = viewModel
        viewBinding.lifecycleOwner = this
        observeOnLiveData()

    }

    private fun observeOnLiveData() {
        viewModel.events.observe(this) { event ->
            handleEvents(event)
        }
    }

    private fun handleEvents(event: HomeEvents) {
        when (event) {
            HomeEvents.NavigateToRoadMaps -> {
                navigateToRoadMaps()
            }

            HomeEvents.NavigateToChatBot -> {
                navigateToChatBoat()
            }
        }
    }

    private fun navigateToRoadMaps() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToChatBoat() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, ChatBoatFragment())
            ?.addToBackStack(null)
            ?.commit()
    }


}


