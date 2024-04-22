package com.route.neuronseekinglearn.home.tabs.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentRoadMapBinding

class RoadMapFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadMapBinding
    private lateinit var viewModel: RoadMapViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentRoadMapBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RoadMapViewModel::class.java]

        initViews()
    }

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

}