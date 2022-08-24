package com.example.nameapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1 , exportSchema = false)
abstract class MyDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDao

    companion object {
        private var INSTANCE: MyDatabase? = null
        fun getInstance(context: Context): MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "roomdb"
                ).allowMainThreadQueries()
                    .build()
            }

            return INSTANCE as MyDatabase
        }
    }

}