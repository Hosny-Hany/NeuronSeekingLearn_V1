package com.route.neuronseekinglearn.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityRegisterBinding
import com.route.neuronseekinglearn.login.LoginActivity
import com.route.neuronseekinglearn.showMessage

class RegisterActivity : AppCompatActivity() {
    lateinit var ViewBinding: ActivityRegisterBinding
    lateinit var ViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initviews()
        SubscribeToLiveData()
    }

    private fun SubscribeToLiveData() {
        ViewModel.ErrorLiveData.observe(this) { error ->
            showMessage(
                message = error.message ?: "some thing want Error",
                posActionName = "OK",
                posAction = { DialogInterface, i ->
                    DialogInterface.dismiss()
                }

            )
        }
    }

    private fun initviews() {
        ViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        ViewModel = ViewModelProvider(this)[(RegisterViewModel::class.java)]
        ViewBinding.lifecycleOwner = this
        ViewBinding.vm = ViewModel
        ViewBinding.content.alreadyHaveAccount
            .setOnClickListener {
                StartActivity()
            }
    }

    private fun StartActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
