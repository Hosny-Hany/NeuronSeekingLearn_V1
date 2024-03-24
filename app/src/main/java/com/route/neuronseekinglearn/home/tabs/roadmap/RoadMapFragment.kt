package com.route.neuronseekinglearn.home.tabs.roadmap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentRoadMapBinding

class RoadMapFragment : Fragment() {
  private lateinit var viewBinding:FragmentRoadMapBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        viewBinding = FragmentRoadMapBinding.inflate(layoutInflater)
        return viewBinding.root
    }

}