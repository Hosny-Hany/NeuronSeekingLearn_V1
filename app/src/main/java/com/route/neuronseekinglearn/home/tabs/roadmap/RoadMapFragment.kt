package com.route.neuronseekinglearn.home.tabs.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentRoadMapBinding
import com.route.neuronseekinglearn.home.tabs.home.HomeFragment
import com.route.neuronseekinglearn.home.tabs.roadmapDetails.RoadmapDetailsFragment

class RoadMapFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadMapBinding
    private lateinit var viewModel: RoadMapViewModel


    var names = listOf(
        "FrontEnd",
        "BackEnd",
        "Android Developer",
        "Flutter Developer",
        "Data Science",
        "Full Stack",
        "UI/UX"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentRoadMapBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    private fun subscribeToLiveData() {
        viewModel.events.observe(this, ::handlEvent)
    }

    private fun handlEvent(roadMapEvent: RoadMapEvent?) {
        when (roadMapEvent) {
            RoadMapEvent.NavigateToHome -> {
                NaigateToHome()
            }

            else -> {

            }
        }
    }

    private fun NaigateToHome() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, HomeFragment())
            ?.addToBackStack(null)
            ?.commit()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        subscribeToLiveData()


    }

    private lateinit var adapter: RoadMapRecyclerAdapter

    private fun initRecyclerview() {
        // You forgot to add layout manager

        viewModel = ViewModelProvider(this)[RoadMapViewModel::class.java]
        adapter = RoadMapRecyclerAdapter(names)
        viewBinding.RoadRecyclerView.adapter = adapter
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel

        adapter.onTrackClickListeners =
            RoadMapRecyclerAdapter.OnTrackClickListeners { trackName ->
                startRoadMapDetails(trackName)
            }
    }

    private fun startRoadMapDetails(trackName: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                R.id.fragment_container,
                RoadmapDetailsFragment.newInstance(trackName)
            )?.addToBackStack(null)
            ?.commit()
    }
}


