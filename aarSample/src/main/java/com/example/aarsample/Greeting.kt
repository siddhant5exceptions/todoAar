package com.example.aarsample

import android.app.Activity
import android.content.Context
import android.widget.Toast

class Greeting {
    fun generateGreetMessage(name: String): String {
        return "Welcome $name"
    }

    fun showToast(mContext: Context, message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
    }
}