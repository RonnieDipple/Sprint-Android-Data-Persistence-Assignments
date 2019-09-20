package com.example.roomsqllite.database.daos

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.roomsqllite.models.Pet

@Dao
interface PetDao {
    @Query("SELECT * FROM Pets")  //Query just like directly accessing sqllite
    // This maps to the @Query above
    fun getAll():List<Pet>

    @Insert(onConflict = REPLACE)// in the event of a conflict inserts pet
    fun insert(pet: Pet)

    @Update(onConflict = REPLACE)//updates pet
    fun update(pet: Pet)

    @Delete
    fun delete(pet: Pet)// deletes pet


}