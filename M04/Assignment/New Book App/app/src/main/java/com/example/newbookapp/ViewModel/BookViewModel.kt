package com.example.newbookapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.newbookapp.Daos.BookDao
import com.example.newbookapp.models.BookItem

class BookViewModel: ViewModel() {

    lateinit var bookDao: BookDao
    val bookItems: LiveData<List<String>> = Transformations.map(bookDao.getAllBooks(), ::getBookName)

    private fun getBookName(books: List<BookItem>): List<String>{
        val booksName: MutableList<String> = ArrayList()
        books.forEach { booksName.add(it.name) }

        return booksName
    }




    /*Transformations above*/

    /*/**
 * Transformation methods for {@link LiveData}.
 * <p>
 * These methods permit functional composition and delegation of {@link LiveData} instances. The
 * transformations are calculated lazily, and will run only when the returned {@link LiveData} is
 * observed. Lifecycle behavior is propagated from the input {@code source} {@link LiveData} to the
 * returned one.
 */*/



}