package com.route.neuronseekinglearn.home.tabs.chatboat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.neuronseekinglearn.databinding.FragmentChatBinding

class ChatBoatFragment : Fragment() {
    private lateinit var viewBinding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentChatBinding.inflate(layoutInflater)
        return viewBinding.root
    }

}