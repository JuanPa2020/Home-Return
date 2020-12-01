package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<TextView>(R.id.btnstart)
        btn.setOnClickListener {
            val pp = Intent(this, principal::class.java)
            startActivity(pp)
        }
    }
}