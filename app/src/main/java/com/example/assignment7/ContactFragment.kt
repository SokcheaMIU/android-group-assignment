package com.example.assignment7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ContactFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mobile = view?.findViewById(R.id.mobile) as Button
        val email = view?.findViewById(R.id.email) as Button
        val fb = view?.findViewById(R.id.fb) as Button
        val twitter = view?.findViewById(R.id.twitter) as Button

        mobile.setOnClickListener() {
            call()
        }

        email.setOnClickListener() {
            email()
        }

        fb.setOnClickListener() {
            fb()
        }

        twitter.setOnClickListener() {
            twitter()
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    private fun call() {

    }

    private fun email() {

    }

    private fun fb() {

    }

    private fun twitter() {

    }
}