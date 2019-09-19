package com.example.readinglistfilestorage

import com.example.readinglistfilestorage.model.Book
import com.example.readinglistfilestorage.view.MainActivity
import com.example.readinglistfilestorage.viewmodel.SharedPrefsDao

class BooksModel {

    fun bookArray(): MutableList<Book>{
        return MainActivity.listOfBooks
    }

    fun returnABook(id: String): Book {

        return Book(id)
    }

    fun returnNextId(): String {
        return SharedPrefsDao.NEXT_ID_RETRIEVAL
    }

    fun passToUpdateBook(book: Book){
        SharedPrefsDao.updateBook(book)

    }
}