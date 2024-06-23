package com.route.neuronseekinglearn.home.tabs.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.FragmentProfileBinding
import com.route.neuronseekinglearn.home.tabs.home.HomeFragment

class ProfileFragment : Fragment() {
    private lateinit var viewBinding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentProfileBinding.inflate(layoutInflater)

        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        initViews()
        subscribeToLiveData()
    }


    private fun subscribeToLiveData() {
        viewModel.events.observe(this, ::handlEvent)
    }

    private fun handlEvent(profileEvent: ProfileEvent) {
        when (profileEvent) {
            ProfileEvent.NavigateToHome -> {
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


    private fun initViews() {
        viewBinding.viewModel = viewModel
        viewBinding.lifecycleOwner = this

    }
}