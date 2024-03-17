package com.route.neuronseekinglearn

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.neuronseekinglearn.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity()
    }


    private fun startActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }, 2000)
    }
}