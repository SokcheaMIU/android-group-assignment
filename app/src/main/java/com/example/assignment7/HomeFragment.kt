package com.example.assignment7

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val act = activity as? AppCompatActivity
        act?.supportActionBar?.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blogTitle = view?.findViewById(R.id.blogTitle) as? Button
        blogTitle?.setOnClickListener() {
            clickBlog(it)
        }

        val blogContent = view?.findViewById(R.id.blogContent) as? Button
        blogContent?.setOnClickListener() {
            clickBlog(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun clickBlog(view: View) {
        val intent = Intent( activity, WebViewActivity::class.java)
        intent.putExtra("title", "Blogs")
        intent.putExtra("url", "https://blogs.oracle.com/java/post/the-arrival-of-java-19")
        startActivity(intent)
    }
}