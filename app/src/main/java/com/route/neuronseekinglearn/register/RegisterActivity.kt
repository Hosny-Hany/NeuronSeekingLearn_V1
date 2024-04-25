package com.route.neuronseekinglearn.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        var sharedPreferences = getSharedPreferences("User Data", Context.MODE_PRIVATE)
        Toast.makeText(this, "data saved successfully", Toast.LENGTH_SHORT).show()
        var editor = sharedPreferences.edit()
        var UserName = viewModel.username.value.toString()
        var UserEmail = viewModel.email.value.toString()
        editor.putString("User_Name", UserName)
        editor.putString("User_Email", UserEmail)
        editor.commit()

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}
