package com.route.neuronseekinglearn.home.tabs

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityHomeBinding
import com.route.neuronseekinglearn.home.tabs.home.HomeFragment
import com.route.neuronseekinglearn.home.tabs.menu.ProfileFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        handleSidebar()
        navigateToHomeFragment()
        navigateToProfileFragment()
    }

    private fun navigateToProfileFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun handleSidebar() {
        toggle = ActionBarDrawerToggle(
            this, viewBinding.drawerLayout,
            R.string.open_string, R.string.close_string
        )

        viewBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}