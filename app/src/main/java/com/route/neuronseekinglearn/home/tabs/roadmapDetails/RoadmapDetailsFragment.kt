package com.route.neuronseekinglearn.home.tabs.roadmapDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentRoadmapDetailsBinding
import com.route.neuronseekinglearn.home.tabs.roadmap.RoadMapFragment

private const val ARG_TRACK_NAME = "track_name "

class RoadmapDetailsFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadmapDetailsBinding
    private var trackName: String? = null
    private var trackContent: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trackName = it.getString(ARG_TRACK_NAME)
        }
        getContent()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentRoadmapDetailsBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.track.text = trackName
        viewBinding.textContent.text = trackContent

    }

    private fun getContent() {
        if (trackName == "FrontEnd") {
            trackContent = getString(R.string.FrontContent)
        }
        if (trackName == "BackEnd") {
            trackContent = getString(R.string.BackEndContent)
        }
        if (trackName == "Android Developer") {
            trackContent = getString(R.string.androidContent)
        }
        if (trackName == "Flutter Developer") {
            trackContent = getString(R.string.FlutterContent)
        }
        if (trackName == "Data Science") {
            trackContent = getString(R.string.AiAndDataScience)
        }
        if (trackName == "Full Stack") {
            trackContent = getString(R.string.FullStackContent)
        }
        if (trackName == "UI/UX") {
            trackContent = getString(R.string.UI_UXContent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(trackName: String) =
            RoadmapDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TRACK_NAME, trackName)
                }
            }
    }

}