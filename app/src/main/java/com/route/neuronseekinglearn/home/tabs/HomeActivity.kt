package com.route.neuronseekinglearn.home.tabs

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.route.neuronseekinglearn.R
import com.route.neuronseekinglearn.databinding.ActivityHomeBinding
import com.route.neuronseekinglearn.home.tabs.home.HomeFragment
import com.route.neuronseekinglearn.home.tabs.menu.ProfileFragment
import com.route.neuronseekinglearn.login.LoginActivity

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewBinding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        drawerLayout = viewBinding.drawerLayout
        viewBinding.navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            navigateToHomeFragment()
            viewBinding.navView.setCheckedItem(R.id.dropList_navigate_home)
        }
    }

    private fun navigateToHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onNavigationItemSelected(@NonNull menuItem: MenuItem): Boolean {
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
        drawerLayout.closeDrawer(viewBinding.navView)
        return true
    }
}
