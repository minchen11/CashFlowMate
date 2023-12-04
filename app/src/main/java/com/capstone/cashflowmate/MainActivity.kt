package com.capstone.cashflowmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.capstone.cashflowmate.databinding.ActivityMainBinding
import com.capstone.cashflowmate.ui.HomeFragment
import com.capstone.cashflowmate.ui.LibraryFragment
import com.capstone.cashflowmate.ui.ShortsFragment
import com.capstone.cashflowmate.ui.SubscriptionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.background = null

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.shorts -> replaceFragment(ShortsFragment())
                R.id.subscriptions -> replaceFragment(SubscriptionFragment())
                R.id.library -> replaceFragment(LibraryFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}