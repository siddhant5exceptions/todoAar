package com.example.aarsample

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.annotation.Keep

@Keep
class Greeting {
    @Keep
    fun generateGreetMessage(name: String): String {
        return "Welcome $name"
    }
    @Keep
    fun showToast(mContext: Context, message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
    }
}