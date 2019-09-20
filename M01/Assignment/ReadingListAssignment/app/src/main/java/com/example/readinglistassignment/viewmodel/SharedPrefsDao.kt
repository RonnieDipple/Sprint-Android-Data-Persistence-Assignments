package com.example.readinglistassignment.viewmodel

import android.content.Context
import com.example.readinglistassignment.model.Book
import com.example.readinglistassignment.view.MainActivity


/*#### Write the Data Access Object for SharedPreferences

Now that we have a functioning app, we need to add our persistence to it. To do this using `SharedPreferences`, we'll store our objects as strings by their id. We will also store a list of active objects in a list of ids. Finally, we'll store a single id value representing the next id to be used

1. Create a `SharedPreferences` data member called `preferences` in your `MainActivity`
2. In the `onCreate` method of that activity, use `this.getSharedPreferences` to store a handle to the activity's `SharedPreferences` object in your `preferences` member.

> This isn't the safest way to access `SharedPreferences` but it works for a simple app like this. Be sure to check if `preferences` is null before trying to access it.

3. Pass in a `Constant String` value as the `SharedPreferences` name and `MODE_PRIVATE` as its access mode.
4. Create a class called `SharedPrefsDao`, all members of this class will be static
5. Create constant keys for id list retreival and next id retreival.
6. Create methods that use these keys to return `String`s which are retreived from `SharedPreferences`. These methods should be named `getAllBookIds` and `getNextId`

> These are methods which will simply return the value given when calling `MainActivity.preferences.getString()` and passing in the right key

7. Create a method that will accept a `Book`'s id and return the `Book` CSV string
8. Create a method to store a book called `updateBook`which accepts a single `Book` object
9. This method will check to see if the provided book is new or an updated version of the same book, if it is new, it will add the id to the list of active ids and increment the next id. The method will then store the book using its id as the key.
10. Build your app to make sure it compiles properly.*/

object SharedPrefsDao{



        const val ID_LIST_RETRIEVAL = "id list retrieval"
        const val NEXT_ID_RETRIEVAL = "next id retrieval"
        const val DAOPREFERENCES = "preferences"
        const val BOOK_CREATED = "BOOK"





    fun getALLBOOKIds(retrieval: String): String {
        if (retrieval == ID_LIST_RETRIEVAL) {
            return MainActivity.preferences.toString()


        }

        return "Incorrect"
    }


    fun getNextId(retrieval: String): String {
        if (retrieval == NEXT_ID_RETRIEVAL) {
            return MainActivity.preferences.toString()
        }

        return "Incorrect"

    }

    fun bookIdToCsv(id: String): String? {
        return MainActivity.preferences.getString(id, "")
    }

    fun updateBook(book: Book) {

        //indices Returns the index of the last item in the list or -1 if the list is empty

        var updated = false
        for (i in MainActivity.listOfBooks.indices) {
            if (MainActivity.listOfBooks[i].id == book.id) {
                MainActivity.listOfBooks[i] = book
                updated = true
            }
        }

        if (!updated) {
            MainActivity.listOfBooks.add(book)
        }
    }


}