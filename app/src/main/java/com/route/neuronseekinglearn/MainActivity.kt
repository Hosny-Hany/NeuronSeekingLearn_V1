package com.route.neuronseekinglearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.neuronseekinglearn.register.RegisterFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        StartActivity()
    }
    private fun StartActivity(){
        Handler(Looper.getMainLooper())
            .postDelayed({
             val intent = Intent(this,RegisterFragment::class.java)
                startActivity(intent)
            },2000)
    }
}