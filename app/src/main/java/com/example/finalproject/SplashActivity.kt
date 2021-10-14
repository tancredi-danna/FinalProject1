package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlin.reflect.KClass


abstract class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class))
        finish()
    }

    abstract fun startActivity(intent: Any)

    private fun Intent(splashActivity: SplashActivity, kClass: KClass<MainActivity>) {

        class MainActivity {

        }
    }}