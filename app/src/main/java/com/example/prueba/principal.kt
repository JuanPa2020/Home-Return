package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        //Ir a la escalera
        val btnpla= findViewById<ImageView>(R.id.btnplay)
        btnpla.setOnClickListener {
            val es = Intent(this, Escalera::class.java)
            startActivity(es)
        }
    }
}