package com.route.neuronseekinglearn.home.tabs.roadmapDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.neuronseekinglearn.databinding.FragmentRoadmapDetailsBinding

private const val ARG_TRACK_NAME = "track_name "
class RoadmapDetailsFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadmapDetailsBinding
    private var trackName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trackName = it.getString(ARG_TRACK_NAME)
        }
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