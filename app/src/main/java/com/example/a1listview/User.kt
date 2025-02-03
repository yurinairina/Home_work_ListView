package com.example.a1listview

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import java.io.Serializable

class User(val name: String, val age: Int) {
    override fun toString(): String {
        return "Имя: $name, Возраст: $age"
    }

}

