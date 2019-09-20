package com.example.newbookapp.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newbookapp.models.BookItem
import java.util.*

@Dao// Again need to let Room know this is an interface

interface BookDao : BaseDao<BookItem> //inheritance, polymorphism
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: BookItem): Long

    @Query(value = "SELECT * FROM books")//gets all books
    fun getAllBooks(): LiveData<List<BookItem>> ///Live data

    @Query(value = "SELECT * FROM books WHERE author_id = :authorId")//Again issues
    fun getBooksWithId(authorId: Int): LiveData<Optional<BookItem>>//Live data same as get all books except Books with Ids


    //Optional above, java docs read

    /*A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.

Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (return a default value if value not present) and ifPresent() (execute a block of code if the value is present).

This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization) on instances of Optional may have unpredictable results and should be avoided.*/
}