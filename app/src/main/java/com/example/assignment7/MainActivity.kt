package com.example.assignment7

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        navController = findNavController(R.id.nav_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val home = HomeFragment()
        val about = AboutMeFragment()
        val work = WorkFragment()
        val contact = ContactFragment()

        nav_view.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> setCurrentFragment(home)
                R.id.aboutMeFragment -> setCurrentFragment(about)
                R.id.workFragment -> setCurrentFragment(work)
                R.id.contactFragment -> setCurrentFragment(contact)
            }
            true
        }

        setCurrentFragment(home)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_fragment, fragment)
            commit()
        }
    }
}