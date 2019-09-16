package com.example.readinglistassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.readinglistassignment.R

/* TODO 4
1. Add a new empty activity called `EditBookActivity`
2. Add fields to edit information stored in the `Book` object
3. Add attributes to the fields to make the layout look good.
4. Go into the `AndroidManifext` file and move the `intent-filter` block to your new activity.
5. Build your app and test the new Activity.
6. Return the `intent-filter` block to your `MainActivity`
*
* */

class EditBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_book)
    }
}
