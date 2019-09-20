package com.example.roomsqllite.models

import androidx.room.Entity
import androidx.room.PrimaryKey


//TODO 1
//THIS IS THE MODEL
// Entity adds this class as well an entity in the database
@Entity(tableName = "Pets")
class Pet(
    //Primary key is how you keep track of this model in the database
    @PrimaryKey var id: Int,
    var name: String,
    var owner: String,
    var type: String,
    var age: Int
)