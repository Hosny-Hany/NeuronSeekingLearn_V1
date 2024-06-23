package com.route.neuronseekinglearn.home.tabs.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.neuronseekinglearn.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {
    private lateinit var viewBinding: FragmentHelpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentHelpBinding.inflate(layoutInflater)

        return viewBinding.root
    }
}