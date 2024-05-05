package com.route.neuronseekinglearn.home.tabs.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentRoadMapBinding
import com.route.neuronseekinglearn.home.tabs.roadmapDetails.RoadmapDetailsFragment

class RoadMapFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadMapBinding


    private var names = listOf(
        "FrontEnd",
        "BackEnd",
        "Android Developer",
        "Flutter Developer",
        "Data Science",
        "Full Stack",
        "Python Developer"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentRoadMapBinding.inflate(inflater, container, false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
    }

    private lateinit var adapter: RoadMapRecyclerAdapter

    private fun initRecyclerview() {
        // You forgot to add layout manager


        adapter = RoadMapRecyclerAdapter(names)
        viewBinding.RoadRecyclerView.adapter = adapter

        adapter.onTrackClickListeners =
           RoadMapRecyclerAdapter.OnTrackClickListeners { trackName->
               startRoadMapDetails(trackName)
           }
    }

    private fun startRoadMapDetails(trackName: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container,
                RoadmapDetailsFragment.newInstance(trackName)
            )?.addToBackStack(null)
            ?.commit()
    }
}

/*
    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        observeOnLiveData()

    }

    private fun observeOnLiveData() {
        viewModel.events.observe(this) { event ->
            handleEvents(event)
        }

    }

    private fun handleEvents(event: RoadMapEvent) {
        when (event) {
            RoadMapEvent.NavigateToFrontEnd -> {
                navigateToFrontEnd()
            }

            RoadMapEvent.NavigateToBackEnd -> {
                navigateToBackEnd()
            }

            RoadMapEvent.NavigateToFlutter -> {
                navigateToFlutter()
            }

            RoadMapEvent.NavigateToAndroid -> {
                navigateToAndroid()
            }

            RoadMapEvent.NavigateToFullStack -> {
                navigateToFullStack()
            }

            RoadMapEvent.NavigateToDataScience -> {
                navigateToDataScience()
            }

            RoadMapEvent.NavigateToPython -> {
                navigateToPython()
            }
        }
    }

    private fun navigateToPython() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToDataScience() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToFullStack() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToAndroid() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToFlutter() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToBackEnd() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun navigateToFrontEnd() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, RoadMapFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

*/