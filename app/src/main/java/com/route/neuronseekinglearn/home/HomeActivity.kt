package com.route.neuronseekinglearn.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var ViewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}