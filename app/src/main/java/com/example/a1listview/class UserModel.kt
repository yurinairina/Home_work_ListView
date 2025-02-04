package com.example.a1listview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


    class UserModel : ViewModel() {
        val userLiveData: MutableLiveData<MutableList<User>> = MutableLiveData(mutableListOf())

    }
