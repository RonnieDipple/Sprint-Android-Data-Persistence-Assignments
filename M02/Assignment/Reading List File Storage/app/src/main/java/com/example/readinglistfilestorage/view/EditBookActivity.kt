package com.example.readinglistfilestorage.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.readinglistfilestorage.R
import com.example.readinglistfilestorage.model.Book
import com.example.readinglistfilestorage.view.MainActivity.Companion.BOOK_CSV
import kotlinx.android.synthetic.main.activity_edit_book.*

/* TODO 5
#### Pass Data Between Activities

Now that the activity can be launched, it needs data. We have two unique use cases that we'll have to deal with.
A. New Entry
​    1. Use `putExtra` to add a new id value to pass to the `EditBookActivity`
For now, you can use the method `getChildCount` to use the item count as a unique id


​    2. In the `onCreate` method of the `EditBookActivity` use `getIntent().getStringExtra()` to get the passed id
B. Edit Entry
​    1. In your `buildItemView`, give the created item an `onClickListener`
​    2. This `onClickListener` must create an `Intent` just like the button, but this one will add the `Book` as a CSV string to the `Intent`
C. Accept Data
​    Now that we have data in the `Intent`, we need to get it from the `Intent`
​    1. In the `onCreate` method of your `EditBookActivity` use `getIntent()` to get a handle on the `Intent`
​    2. Use `getExtra` and pass it your tag for id to pull the id from the `Intent`
​    3. Use `getStringExtra` to get your `Book` which was encoded as a CSV string
​    4. If your `Book` string isn't null, use it to build a `Book` object and pull the components from it.
​    5. Add your data as text to your `EditText` fields.
*
* */

class EditBookActivity : AppCompatActivity() {

     var bookObject = Book("", "", true, "")

    override fun onBackPressed() {
        returnData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_book)
        val bookCsv = intent.getStringExtra(BOOK_CSV)

        if (bookCsv != null) {
            bookObject = Book(bookCsv)
            edit_text_book_title.setText(bookObject.title)
            edit_text_reason.setText(bookObject.reasonToRead)


        }

        button_submit.setOnClickListener {
            returnData()
        }

        button_cancel.setOnClickListener {
            cancelData()
        }


    }

    fun returnData() {
        val bookObject2 = Book(
            edit_text_book_title.text.toString(),
            edit_text_reason.text.toString(),
            true,
            bookObject.id!!
        )

        val intent = Intent()
        intent.putExtra("csv", bookObject2.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun cancelData() {
        val cancel = Intent()
        setResult(Activity.RESULT_CANCELED, cancel)
        finish()


    }


}
