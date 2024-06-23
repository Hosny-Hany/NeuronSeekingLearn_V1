package com.route.neuronseekinglearn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.neuronseekinglearn.common.PreferencesManager
import com.route.neuronseekinglearn.home.tabs.HomeActivity
import com.route.neuronseekinglearn.register.RegisterActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity()
    }


    private fun startActivity() {
        val preferencesManager = PreferencesManager(this)

        val isLoggedIN = preferencesManager.getLoginState()

        if (isLoggedIN){

            Handler(Looper.getMainLooper())
                .postDelayed({
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }, 2000)
        }else{

            Handler(Looper.getMainLooper())
                .postDelayed({
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }, 2000)
        }

    }


}