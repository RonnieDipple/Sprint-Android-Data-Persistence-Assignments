package com.example.newbookapp.Daos

import androidx.room.Dao
import androidx.room.Query
import com.example.newbookapp.models.AuthorModel

@Dao // Without this room won't recognise this as dao which is an interface
interface AuthorDao: BaseDao<AuthorModel>{
    @Query(value = "SELECT * FROM authors")// all authors
    fun getAllAuthors(): List<AuthorModel>

    @Query(value = "SELECT * FROM authors WHERE author_id = :authorId") //This gave me hell just because I mixed up the : and the authorId name
    fun getAuthorId(authorId: Long): AuthorModel?

    @Query(value = "SELECT author_id FROM authors")//all ids
    fun getALLIds():List <Long>
}