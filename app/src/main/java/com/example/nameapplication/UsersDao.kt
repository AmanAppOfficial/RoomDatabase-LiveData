package com.example.nameapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert
    fun insertUsers(users: Users)

    @Query("Select * FROM users")
    fun getAllUsers(): LiveData<List<Users>>

}