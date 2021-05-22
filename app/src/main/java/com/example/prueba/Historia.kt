package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.prueba.R.drawable.*
import kotlinx.android.synthetic.main.activity_historia.*
import kotlinx.android.synthetic.main.activity_musica.*

class Historia: AppCompatActivity() {

    lateinit var adapters: Adapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia)

        var list = mutableListOf<Int>(historia_uno, historia_dos, historia_tres, historia_cuatro)

        Toast.makeText(this, "Desliza a la derecha", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Desliza a la derecha", Toast.LENGTH_SHORT).show()

        adapters = Adapters(this)
            adapters.setContentList(list)
            terminar.adapter = adapters

    }
}