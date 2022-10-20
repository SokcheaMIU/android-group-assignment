package com.example.assignment7

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val title = intent.getStringExtra("title") as String
        val webViewUrl = intent.getStringExtra("url") as String
        val webview = findViewById(R.id.webview) as? WebView
        webview?.let {
            it.loadUrl(webViewUrl)
            it.settings.javaScriptEnabled = true
            it.webViewClient = WebViewClient()
        }

        val topBarDrawableColor = ColorDrawable(ContextCompat.getColor(this, R.color.purple_700))
        supportActionBar?.setBackgroundDrawable(topBarDrawableColor)
        supportActionBar?.title = title
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}