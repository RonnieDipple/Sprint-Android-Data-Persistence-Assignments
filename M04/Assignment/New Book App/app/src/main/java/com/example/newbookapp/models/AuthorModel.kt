package com.example.newbookapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Model for SqlLite, Room does most of the work
@Entity(tableName = "authors")
data class AuthorModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "author_id")
    val authorId: Long = 0,
    @ColumnInfo(name = "author_name")
    var authorName: String
)