package com.example.prueba

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import com.example.prueba.R.*
import com.example.prueba.R.raw.*
import kotlinx.android.synthetic.main.activity_musica.*
import android.widget.SeekBar
import android.widget.Toast

class Musica : AppCompatActivity() {
    lateinit var mp: MediaPlayer
    fun play(v: View){
        if(mp.isPlaying){
            mp.pause()
            Toast.makeText(this, "Pausaste la música", Toast.LENGTH_SHORT).show()
        } else {
            mp.start()
            Toast.makeText(this, "Reproduciendo música", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musica)

        val mventana = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(mventana)
        val ancho = mventana.widthPixels
        val alto = mventana.heightPixels
        window.setLayout((ancho * 0.85).toInt(), (alto * 0.7).toInt())

        val music = mutableListOf<Int>(yeah,yeah)
        mp = MediaPlayer.create(this, yeah)
        mp.setVolume(0.5f, 0.5f)
        volumen.setProgress(30)
        volumen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                val vl = i / 100f
                mp.setVolume(vl,vl)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        val on= findViewById<ImageView>(id.onoff1)
        on.setOnClickListener {
            play(onoff1)
        }
    }
}
