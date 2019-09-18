package com.example.readinglistassignment.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.readinglistassignment.BooksController
import com.example.readinglistassignment.model.Book
import com.example.readinglistassignment.R
import com.example.readinglistassignment.view.MainActivity.Companion.listOfBooks
import kotlinx.android.synthetic.main.activity_edit_book.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


/*TODO 3.
  Write a `buildItemView` method which will accept a `Book` object and return a custom view to display information about the book.
> Typically these views will just show the title of the book. In the next couple weeks, we'll show you how to define custom layouts for lists
3. Hardcode a list of `Book` objects to test your methods.
Be sure to add all views returned from your `buildItemView` method to the ScrollView's child using `.addView(View)`
4. Test your app. */

class MainActivity : AppCompatActivity() {


    companion object {

        const val NEW_BOOK = 999
        const val BOOK_CSV = "book csv"
        const val MY_PREF = "preferences"
        lateinit var preferences: SharedPreferences
        val listOfBooks = mutableListOf<Book>()


    }

    /* Book(
         "Childhoods End",
         "Created in the 50s this book was an inspiration for Independence day the movie ",
         true, "007"
     ),
     Book(
         "Ready Player One",
         "It is chock full of 80s references",
         true,
         "9000"
     )


 )*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        preferences = this.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)


        /*
        * TODO 4
        *
        * #### Link the Activities

            Now that you have built both activities. You'll need to link the two activities and pass data between them.

            1. In your `MainActivity` add an `onClickListener` to your button
            2. In the listener create a new `Intent` passing in the current `Context` and the `EditBookActivity.class`
            3. Call `startActivity()` with your new `Intent`
            4. Build and Run your app to test that the button now navigates to the `EditBookActivity`
        * */


        fab.setOnClickListener { view ->
            val intent = Intent(this, EditBookActivity::class.java)
            intent.putExtra("ID", scrollView.childCount.toString())
            startActivityForResult(intent, NEW_BOOK)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == NEW_BOOK && data != null) {
            BooksController().handleEditActivityResult(data)
            loadViews()


        }

    }

    fun loadViews() {


        linear_layout_list.removeAllViews()

        for (i in 0 until listOfBooks.size) {
            listOfBooks[i].id = linear_layout_list.childCount.toString()
            linear_layout_list.addView(BooksController().buildItemView(linear_layout_list,listOfBooks[i]))


        }


    }
}






