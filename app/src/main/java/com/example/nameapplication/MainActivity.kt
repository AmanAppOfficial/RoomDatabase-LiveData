package com.example.nameapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)

        val modelFactory= MainViewModelFactory(application);
        val model = ViewModelProvider(this, modelFactory)[MainViewModel::class.java]

        model.userList.observe(this){
            if(it.isNotEmpty())
            Log.e("userList" , it.size.toString())
        }

        btn.setOnClickListener{
            model.insert(Users( System.currentTimeMillis(), "Work"))
        }





    }




}