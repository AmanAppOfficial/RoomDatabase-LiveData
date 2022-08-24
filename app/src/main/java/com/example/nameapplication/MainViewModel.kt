package com.example.nameapplication

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel(var application: Application):  ViewModel() {

    private var userRepo = UserRepo(application)
    internal val userList: LiveData<List<Users>> = userRepo.getAllUsersRepo()

    fun insert(users: Users){
        userRepo.insertRepo(users)
    }

}