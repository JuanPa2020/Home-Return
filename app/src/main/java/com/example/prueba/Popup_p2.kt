package com.example.prueba

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity

class Popup_p2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_p1)
        
        val mventana = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(mventana)
        val ancho = mventana.widthPixels
        val alto = mventana.heightPixels
        window.setLayout((ancho * 0.85).toInt(), (alto * 0.7).toInt())
    }
}
