package com.example.newbookapp.models

import androidx.room.*

@Entity(
    tableName = "books", indices = [(Index(value = ["book_id"], name = "idx_books_book_id"))],
    foreignKeys = [(ForeignKey(

        entity = AuthorModel::class
        , parentColumns = ["author_id"]
        , childColumns = ["book_id"]
        , onUpdate = ForeignKey.CASCADE
        , onDelete = ForeignKey.CASCADE

    ))]

)

data class BookItem(
    //book has an author that’s why we need the authorId to specify who is the author of the book.
    @PrimaryKey @ColumnInfo(name = "author_id")
    val authorId: Long,
    @ColumnInfo(name = "book_id")
    val bookId: Long,
    val name: String
)