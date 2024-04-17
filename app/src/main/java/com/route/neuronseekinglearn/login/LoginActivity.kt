package com.route.neuronseekinglearn.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.databinding.ActivityLoginBinding
import com.route.neuronseekinglearn.home.HomeActivity
import com.route.neuronseekinglearn.register.RegisterActivity
import com.route.neuronseekinglearn.showDialog

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {

        viewModel.MessageLiveData.observe(this) { error ->
            showDialog(
                message = error.message ?: "some thing want Error",
                posMessage = "OK",
                posAction = {
                }
            )
        }
        viewModel.events.observe(this, ::handleEvents)
    }

    private fun handleEvents(loginEvent: LoginEvent?) {
        when (loginEvent) {
            LoginEvent.NavigateToHome -> {
                NavigateToHome()
            }

            LoginEvent.NavigateToRegister -> {
                NavigateToRegister()
            }

            else -> {

            }
        }
    }


    private fun NavigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun NavigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initViews() {
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewModel = ViewModelProvider(this)[(LoginViewModel::class.java)]
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel

    }
}
