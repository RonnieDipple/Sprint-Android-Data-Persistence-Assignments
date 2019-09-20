package com.example.newbookapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newbookapp.R
import com.example.newbookapp.ViewModel.BookViewModel
import com.example.newbookapp.models.BookItem

class MainActivity : AppCompatActivity() {
    private val bookNames: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.bookItems.observe(this, object : Observer<List<String>> {

            override fun onChanged(t: List<String>?) {
                if (bookNames.isNotEmpty())
                    bookNames.clear()
                bookNames.addAll(t) //didn't have time to fix this before sprint

            }

        })
    }
}
