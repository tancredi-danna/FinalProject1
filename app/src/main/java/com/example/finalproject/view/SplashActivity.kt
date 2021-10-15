package com.example.finalproject.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delay()

        chekLogin()

        finish()
    }

    private fun chekLogin() {
        var sharedPref = getPreferences(MODE_PRIVATE)
        if (sharedPref.getBoolean("logged",true)){
            goToMain()
        }else if(sharedPref.equals(null) || sharedPref.getBoolean("logged",false)){
            goToLogin()
        }
    }

    fun delay(){
        Handler(Looper.getMainLooper()).postDelayed({
        }, 1000)
    }

    private fun goToMain() {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun goToLogin(){
        var intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}