package com.route.neuronseekinglearn.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityRegisterBinding
import com.route.neuronseekinglearn.home.tabs.HomeActivity
import com.route.neuronseekinglearn.login.LoginActivity
import com.route.neuronseekinglearn.showDialog

class RegisterActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.MessageLiveData.observe(this) { error ->
            showDialog(
                Message = error.message ?: "some thing want Error",
                posMessage = "OK",
                posAction = {
                }
            )
        }
        viewModel.events.observe(this, ::handleEvents)
    }

    private fun handleEvents(registerEvent: RegisterEvent?) {
        when (registerEvent) {
            RegisterEvent.NavigateToHome -> {
                navigateToHome()
            }

            RegisterEvent.NavigateToLogin -> {
                navigateToLogin()
            }

            else -> {

            }
        }
    }

    private fun initViews() {
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProvider(this)[(RegisterViewModel::class.java)]
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}
