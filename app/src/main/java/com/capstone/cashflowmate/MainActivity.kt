package com.capstone.cashflowmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.capstone.cashflowmate.databinding.ActivityMainBinding
import com.capstone.cashflowmate.ui.HomeFragment
import com.capstone.cashflowmate.ui.InsertionActivity
import com.capstone.cashflowmate.ui.ProfileFragment
import com.capstone.cashflowmate.ui.SubscriptionFragment
import com.capstone.cashflowmate.ui.TransactionFragment
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.background = null

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.transaksi -> makeCurrentFragment(TransactionFragment())
                R.id.subscriptions -> replaceFragment(SubscriptionFragment())
                R.id.profil -> replaceFragment(ProfileFragment())
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

    fun floating_button(view: View){
        val intent = Intent(this, InsertionActivity::class.java)
        startActivity(intent)
    }

    private fun makeCurrentFragment(fragment: Fragment) { //method 2
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }
}