package com.example.readinglistassignment

import android.app.Activity
import android.content.Intent
import android.widget.LinearLayout
import android.widget.TextView
import com.example.readinglistassignment.model.Book
import com.example.readinglistassignment.view.EditBookActivity
import com.example.readinglistassignment.view.MainActivity
import com.example.readinglistassignment.view.MainActivity.Companion.BOOK_CSV
import com.example.readinglistassignment.view.MainActivity.Companion.NEW_BOOK


/*#### Write a controller to format the data and communicate with the model

1. Create a class called `BooksContoller`
2. Refactor your `buildItemView` method to move it to your new class.

> In order to call `startActivityForResult` in this method, you'll need to pass a handle to the activity you'll be building

3. Remove your list of `Book` objects, the loop to build their views, and the `LinearLayout`.
4. In your `BookController`write a method called `getBooksView`that accepts a `Context` object
5. In the new method, you'll get the list of book objects from the `BooksModel`, create a new `LinearLayout` object, use `buildItemView` to add view items to it, and return the `LinearLayout` view.

> use `imageView.getLayoutParams().width= ViewGroup.LayoutParams.MATCH_PARENT;` to set the with to match parent in your list items

6. Write a method called `handleEditActivityResult` which will accept an `Intent` object, pull the returned data from it and use it to update the model.

> This will replace some of the code in the `onActivityResult` method of your `MainActivity`

7. In the `onActivityResult` method, you will now check the requestCode and the resultCode and call the `handleEditActivityResult` method, passing it the `Intent` object.
8. In the `onCreate` method, you will now get a handle to the `ScrollView` and then call the `getBooksView` and pass that result to the `ScrollView`'s `addView` method.
9. Test the app

#### */

class BooksController {

    fun buildItemView(layout: LinearLayout, book: Book): TextView {
        val context = layout.context
        val activity = context as Activity
        val myView = TextView(context)
        myView.text = book.title
        myView.textSize = 15f
        myView.setOnClickListener {

            val intent = Intent(context, EditBookActivity::class.java)
            intent.putExtra(BOOK_CSV, book.toString())
            activity.startActivityForResult(intent, NEW_BOOK)
        }

        return myView
    }


    fun handleEditActivityResult(intent: Intent) {

        val csv = intent.getStringExtra("csv")
        if (csv != null) {
            val csvBook = Book(csv)

            var hasBeenFound = false

            for (i in 0 until MainActivity.listOfBooks.size) {

                if (MainActivity.listOfBooks[i].id == csvBook.id) {
                    MainActivity.listOfBooks[i].hasBeenRead = csvBook.hasBeenRead
                    MainActivity.listOfBooks[i].reasonToRead = csvBook.reasonToRead
                    MainActivity.listOfBooks[i].title = csvBook.title
                    hasBeenFound = true
                }

            }

            if (!hasBeenFound) {
                MainActivity.listOfBooks.add(csvBook)
            }


        }

    }


    /* fun buildItemView(book: Book): View {

         val myView = TextView(this)
         val id = book.id
         myView.text = book.title
         myView.textSize = 15f
         myView.setOnClickListener {
             val intent = Intent(this, EditBookActivity::class.java)
             intent.putExtra(BOOK_CSV, book.toString())
         }
         return myView


     }*/


}