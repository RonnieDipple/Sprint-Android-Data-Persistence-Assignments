package com.example.readinglistassignment

import com.example.readinglistassignment.model.Book
import com.example.readinglistassignment.view.MainActivity
import com.example.readinglistassignment.viewmodel.SharedPrefsDao

class BooksModel {

    fun bookArray(): MutableList<Book>{
        return MainActivity.listOfBooks
    }

    fun returnABook(id: String): Book{

        return Book(id)
    }

    fun returnNextId(): String {
        return SharedPrefsDao.NEXT_ID_RETRIEVAL
    }

    fun passToUpdateBook(book: Book){
        SharedPrefsDao.updateBook(book)

    }
}