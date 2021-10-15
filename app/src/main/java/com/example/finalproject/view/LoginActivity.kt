package com.example.finalproject.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.databinding.LoginLayoutBinding
import com.example.finalproject.model.entity.FdataBase.Companion.mappaIscritti
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    lateinit var psd : String
    lateinit var mail: String
    lateinit var button: Button
    lateinit var binding: LoginLayoutBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        button = binding.btnGo
        //shared preferences
        //post method
        button.setOnClickListener {
            //controllo login effettuato dalla shared
            mail = binding.editTextTextEmailAddress.text.toString()
            psd = binding.editTextTextPassword.text.toString()
            var accessopermesso= false
            if(mail.isNotEmpty() && psd.isNotEmpty()){
                var passwordDb:String? = null
                try{
                    passwordDb =  mappaIscritti.getValue(mail)
                }catch (e:Exception){
                    Toast.makeText(this,"email o password errata",Toast.LENGTH_LONG).show()
                }
                if(passwordDb != null && psd.equals(passwordDb)){
                    logged()
                    goToMain()
                }else{
                    Toast.makeText(this,"email o password errata",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"inserisci i dati correttamente",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun logged() {
        val sharedPref = getPreferences(MODE_PRIVATE)
        sharedPref.edit().putString("name",mail).commit()
        sharedPref.edit().putBoolean("logged",true).commit()
    }

    private fun goToMain() {
        var intent = Intent(this,MainActivity::class.java).apply {
            putExtra("email",mail)
        }
        startActivity(intent)
    }


}