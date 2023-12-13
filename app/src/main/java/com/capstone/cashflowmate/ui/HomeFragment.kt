package com.capstone.cashflowmate.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.capstone.cashflowmate.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the profileHome ImageView by its ID
        val profileImageView: ImageView = rootView.findViewById(R.id.profileHome)

        // Set a click listener on the profile ImageView
        profileImageView.setOnClickListener {
            // Create an Intent to start the ProfileActivity
            val intent = Intent(requireContext(), ProfileActivity::class.java)

            // Start the ProfileActivity
            startActivity(intent)
        }

        return rootView
    }
}