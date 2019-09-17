package com.example.readinglistassignment.model

//TODO 1 #### Book
//
//1. Create a "Book.java" file. Create a class called `Book`
//2. This class should have the following data members:
//   - A `title` String
//   - A `reasonToRead` String
//   - A `hasBeenRead` boolean
//   - An `id` String
//3. Create two constructors.
//   a. One that accepts and assigns all data members
//   b. One that parses a CSV string to an object
//4. Write getters for each of the data members
//5. Write a `toCsvString` method to convert the object to a CSV string
//
//> Make sure your CSV constructor and CSV output methods match formatting
//
//####

class Book {
    override fun toString(): String {
        return "$title , $reasonToRead , ${hasBeenRead.toString()}"
    }

    var title: String? = null
    var reasonToRead: String? = null
    var hasBeenRead: Boolean? = null
    var id: String? = null

    constructor(
        title: String,
        reasonToRead: String,
        hasBeenRead: Boolean,
        id: String
    ){
        this.title = title
        this.reasonToRead = reasonToRead
        this.hasBeenRead = hasBeenRead
        this.id = id
    }

    constructor(
        csvString: String

    )

   {val splitString = csvString.split(" ,")
       this.title = splitString[0]
       this.reasonToRead = splitString[1]
       when (splitString[2]){
           "true"-> this.hasBeenRead = true
           else -> this.hasBeenRead = false

       }
   }

}
