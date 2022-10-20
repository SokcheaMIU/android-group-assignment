package com.example.assignment7

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webview = findViewById(R.id.webview) as? WebView
        webview?.let {
            it.loadUrl("https://blogs.oracle.com/java/post/the-arrival-of-java-19")
            it.settings.javaScriptEnabled = true
            it.webViewClient = WebViewClient()
        }

        supportActionBar?.title = "WebView"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}