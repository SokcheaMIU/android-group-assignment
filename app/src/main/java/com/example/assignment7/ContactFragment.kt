package com.example.assignment7

import android.content.Intent
import android.net.Uri
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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mobile = view?.findViewById(R.id.mobile) as Button
        val email = view?.findViewById(R.id.email) as Button
        val fb = view?.findViewById(R.id.fb) as Button
        val twitter = view?.findViewById(R.id.twitter) as Button

        mobile?.setOnClickListener() {
            call(mobile.text.toString())
        }

        email?.setOnClickListener() {
            email(email.text.toString())
        }

        fb?.setOnClickListener() {
            fb(fb.text.toString())
        }

        twitter?.setOnClickListener() {
            twitter(twitter.text.toString())
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    private fun call(number: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $number"))
        startActivity(intent)
    }

    private fun email(recipient: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello Selena")
        mIntent.putExtra(Intent.EXTRA_TEXT, "This is my assignment.")
        startActivity(Intent.createChooser(mIntent, "Choose application to send Email...."))
    }

    private fun fb(fb: String) {
        val intent = Intent( activity, WebViewActivity::class.java)
        intent.putExtra("title", "Facebook")
        intent.putExtra("url", fb)
        startActivity(intent)
    }

    private fun twitter(twitter: String) {
        val intent = Intent( activity, WebViewActivity::class.java)
        intent.putExtra("title", "Twitter")
        intent.putExtra("url", twitter)
        startActivity(intent)
    }
}