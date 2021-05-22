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

        //Ir a la historia
        val btnhistoria= findViewById<ImageView>(R.id.btnhistoria)
        btnhistoria.setOnClickListener {
            val es = Intent(this, Historia::class.java)
            startActivity(es)
        }

        //Ir a la ajustes
        val aju= findViewById<ImageView>(R.id.btnajustes)
        aju.setOnClickListener {
            val ajus = Intent(this, Ajustes::class.java)
            startActivity(ajus)
        }

        //Ir a la musica
        val mus= findViewById<ImageView>(R.id.btnmusica)
        mus.setOnClickListener {
            val musi = Intent(this, Musica::class.java)
            startActivity(musi)
        }
    }
}