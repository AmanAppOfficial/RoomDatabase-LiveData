package com.example.nameapplication

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData

class UserRepo(private val application: Application) {

    private val database = MyDatabase.getInstance(application)
    private val usersDao = database.usersDao()


     fun getAllUsersRepo(): LiveData<List<Users>>{
         return usersDao.getAllUsers()
    }

    fun insertRepo(users: Users){
        usersDao.insertUsers(users)
    }

}