package com.route.neuronseekinglearn.home.tabs.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.common.PreferencesManager
import com.route.neuronseekinglearn.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var viewBinding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var preferencesManager: PreferencesManager
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
    }

    private fun initViews() {
        viewBinding.viewModel = viewModel
        viewBinding.lifecycleOwner = this
        preferencesManager = PreferencesManager(requireContext())

        viewBinding.content.email.hint = preferencesManager.getSavedUser().email
        viewBinding.content.fullName.hint = preferencesManager.getSavedUser().userName
    }
}