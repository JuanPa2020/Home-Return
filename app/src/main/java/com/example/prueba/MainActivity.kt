package com.example.prueba

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val bandera = 1
            if (bandera == 1) {
                val intent = Intent(this, principal::class.java)
                startActivity(intent)
            }
            finish()
        }, 3000)
    }
}



