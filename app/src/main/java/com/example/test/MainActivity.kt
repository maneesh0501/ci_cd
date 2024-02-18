package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str = MutableLiveData<String>("abc")
        make(str) {
            Log.e("Manish", "onCreate: = "+str)
        }

        lifecycleScope.launch(Dispatchers.Default) {
            for (a in 1..10) {
                str.value = str.value + a
                delay(1000)
            }
        }
    }

    fun make(str: LiveData<String>, callback: ( ) -> Unit) {
        var st = str.value
        str.observe(this) {
            if (it != st) {
                st = it
                callback.invoke()
            }
        }
    }

}