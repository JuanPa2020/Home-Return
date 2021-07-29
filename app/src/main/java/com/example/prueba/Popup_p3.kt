package com.example.prueba

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_popup_p3.*

class Popup_p3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_p3)
        
        val mventana = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(mventana)
        val ancho = mventana.widthPixels
        val alto = mventana.heightPixels
        window.setLayout((ancho * 0.85).toInt(), (alto * 0.7).toInt())
        // Respuesta 1
        val r1= findViewById<Button>(R.id.r)
        // Respuesta 2
        val r2= findViewById<Button>(R.id.r1)
        // Respuesta 3
        val r3= findViewById<Button>(R.id.r2)
        val clickListener= (View.OnClickListener {
            respuesta()
        })
        r1.setOnClickListener(clickListener)
        r2.setOnClickListener(clickListener)
        r3.setOnClickListener(clickListener)

    }

    private fun respuesta() {
        val resp: ImageView = findViewById(R.id.icon_res)
        if (r.isPressed){
            resp.setImageResource(R.drawable.icon_correcto)
            Toast.makeText(this, "¡Es correcto!", Toast.LENGTH_SHORT).show()
            r1.isEnabled=false
            r2.isEnabled=false
        }else if (r1.isPressed||r2.isPressed){
            resp.setImageResource(R.drawable.icon_error)
            Toast.makeText(this, "Respuesta erronea", Toast.LENGTH_SHORT).show()
            r.isEnabled=false
            r2.isEnabled=false
        }
        val intent = Intent();
        intent.putExtra("result", r.isPressed);
        setResult(Activity.RESULT_OK, intent)
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        },3000)
    }

}