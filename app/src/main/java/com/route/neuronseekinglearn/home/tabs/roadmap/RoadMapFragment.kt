package com.route.neuronseekinglearn.home.tabs.roadmap

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.neuronseekinglearn.Constant
import com.route.neuronseekinglearn.databinding.FragmentRoadMapBinding
import com.route.neuronseekinglearn.home.tabs.details.RoadDetailsFragment

class RoadMapFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadMapBinding

    var names = listOf(
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
    ): View? {
        viewBinding = FragmentRoadMapBinding.inflate(inflater, container, false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  viewModel = ViewModelProvider(this)[RoadMapViewModel::class.java]
        // initViews()
        initRecyclerview()
    }

    lateinit var adapter: RoadMapRecyclerAdapter

    private fun initRecyclerview() {
        adapter = RoadMapRecyclerAdapter(names)
        adapter.onItemClickListner =
            RoadMapRecyclerAdapter.onItemClickListners { position, name ->

                startRoadMapDetails(position, name)
            }
        viewBinding.RoadRecyclerView.adapter = adapter
    }

    private fun startRoadMapDetails(index: Int, name: String) {
        val intent = Intent(context, RoadDetailsFragment::class.java)
        intent.putExtra(Constant.RoadMap_INDEX, index + 1)
        intent.putExtra(Constant.RoadMap_NAME, name)
        startActivity(intent)
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