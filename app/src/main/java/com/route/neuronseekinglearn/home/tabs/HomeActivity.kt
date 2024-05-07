package com.route.neuronseekinglearn.home.tabs

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityHomeBinding
import com.route.neuronseekinglearn.home.tabs.home.HomeFragment
import com.route.neuronseekinglearn.home.tabs.menu.ProfileFragment
import com.route.neuronseekinglearn.login.LoginActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        handleSidebar()
        navigateToHomeFragment()
        viewBinding.navView.setNavigationItemSelectedListener { menuItem ->
            onNavigationItemSelected(menuItem)
        }

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

    @Override
    private fun onNavigationItemSelected(@NonNull menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.dropList_navigate_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .addToBackStack(null)
                    .commit()

            }

            R.id.dropList_navigate_profile -> {

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ProfileFragment())
                    .addToBackStack(null)
                    .commit()
            }

            R.id.dropList_navigate_Help -> {

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ProfileFragment())
                    .addToBackStack(null)
                    .commit()
            }

            R.id.dropList_navigate_Logout -> {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }
        return true
    }


}
