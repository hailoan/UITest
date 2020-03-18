package com.example.uitest4application.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


inline fun <reified T : Any> AppCompatActivity.launcherActivity(
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)
inline fun Context.makerToast(mess:String){
    Toast.makeText(this,mess,Toast.LENGTH_SHORT).show()
}