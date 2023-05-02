package com.example.waywise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.waywise.navigation.DiscoverFragment
import com.example.waywise.navigation.ExploreFragment
import com.example.waywise.navigation.ProfileFragment
import com.example.waywise.navigation.SuggestionFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(DiscoverFragment())
        bottomNav = findViewById(R.id.nav_view) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_discover -> {
                    loadFragment(DiscoverFragment())
                    true
                }
                R.id.navigation_suggestions -> {
                    loadFragment(SuggestionFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.navigation_explorer -> {
                    loadFragment(ExploreFragment())
                    true
                }

                else -> {
                    loadFragment(DiscoverFragment())
                    true
                }
            }
        }



    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}