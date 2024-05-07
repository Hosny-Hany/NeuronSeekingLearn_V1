package com.route.neuronseekinglearn.home.tabs.roadmapDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.neuronseekinglearn.databinding.FragmentRoadmapDetailsBinding

private const val ARG_TRACK_NAME = "track_name "
private const val ARG_TRACK_CONTENT = "track_content"

class RoadmapDetailsFragment : Fragment() {
    private lateinit var viewBinding: FragmentRoadmapDetailsBinding
    private var trackName: String? = null
    private var trackContent: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trackName = it.getString(ARG_TRACK_NAME)
            trackContent = it.getString(ARG_TRACK_CONTENT)
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
        viewBinding.textContent.text = trackContent
    }

    companion object {
        @JvmStatic
        fun newInstance(trackName: String) =
            RoadmapDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TRACK_NAME, trackName)
                    putString(ARG_TRACK_CONTENT, trackContent)
                }
            }
    }

}