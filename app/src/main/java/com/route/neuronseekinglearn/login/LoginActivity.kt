package com.route.neuronseekinglearn.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var ViewBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    }
}
