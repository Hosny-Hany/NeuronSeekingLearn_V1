package com.route.neuronseekinglearn.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.neuronseekinglearn.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}
