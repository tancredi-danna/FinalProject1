package com.example.finalproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delay()
        sharedPref = getSharedPreferences("login",MODE_PRIVATE)
        if (sharedPref.getBoolean("logged",true)){
            goToMain()
        }else if(sharedPref == null || sharedPref.getBoolean("logged",false)){
            goToLogin()
        }


        finish()
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