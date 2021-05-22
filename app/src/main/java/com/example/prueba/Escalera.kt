package com.example.prueba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.prueba.*
import com.example.prueba.R.*
import com.example.prueba.R.drawable.*
import kotlinx.android.synthetic.main.activity_escalera.*
import java.util.*


class Escalera : AppCompatActivity() {

    lateinit var hynu: ImageView
    lateinit var pepe: ImageView
    lateinit var dank: ImageView
    lateinit var animation: Animation
    lateinit var animationm: Animation


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_escalera)

        val casillas = arrayListOf<ImageView>(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30)
        val imgcasillas = mutableListOf<Int>(casilla1, casilla2, casilla3, casiilla4, casilla5, casilla6, casilla7, casilla8, casilla9, casilla10, casilla11, casilla12, casilla13, casilla14, agujero1, casilla16, casilla17, casilla18, casilla19, nave, casilla21, casilla22, casilla23, casilla24, casilla25, agujero2, casilla27, casilla28, casilla29, casilla30)
        hynu = findViewById(id.hynu)
        dank = findViewById(id.dank)
        val diceImages = mutableListOf<Int>(d1, d2, d3, d4, d5, d6)
        val lanzamiento1 = mutableListOf<Int>(d1, d2, d3, d4, d5, d6)
        val imgq = mutableListOf<Int>(m1, m2, m3, m4, m5, m6)


        // initialize the animation
        animation = AnimationUtils.loadAnimation(this@Escalera, anim.shake_anim)

        // initialize the animation
        animationm = AnimationUtils.loadAnimation(this@Escalera, anim.pepe)

        //posicion en el tablero
        var posj1 = 0
        var posj2 = 0

        //turno de cada jugador
        var turno = 0
        //jugador
        var random = Random().nextInt(6) + 1
        //maquina
        var randonm = Random().nextInt(6) + 1
        //lanzamiento1
        var random1 = Random().nextInt(6) + 1
        var turnom = 1

        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        fun QuitarDadoMaquina() {
            dado_player.isVisible = true
            dado_maquina.isVisible = false
        }

        fun QuitarDadoPlayer() {
            dado_player.isVisible = false
            dado_maquina.isVisible = true
        }

        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        fun casilla_point() {
            when (posj1) {
                2 -> {
                    val pop1 = Intent(this, Popup_p1::class.java)
                    Toast.makeText(this, "Caiste en el planeta Dankn", Toast.LENGTH_SHORT).show()
                    startActivity(pop1)
                }
                7 -> {
                    val p2 = Intent(this, Popup_p2::class.java)
                    Toast.makeText(this, "Caiste en el planeta Dankn", Toast.LENGTH_SHORT).show()
                    startActivity(p2)
                    Thread.sleep(3000)
                }
                13 -> {
                    val pop3 = Intent(this, Popup_p3::class.java)
                    startActivity(pop3)
                    Thread.sleep(3000)
                }
                15 -> {
                    val pop4 = Intent(this, Popup_p4::class.java)
                    startActivity(pop4)
                    Thread.sleep(3000)
                }
                20 -> {
                    val pop5 = Intent(this, Popup_p5::class.java)
                    startActivity(pop5)
                    Thread.sleep(3000)
                }
                26 -> {
                    val pop6 = Intent(this, Popup_p6::class.java)
                    startActivity(pop6)
                    Thread.sleep(3000)
                }
                31 -> {
                    Toast.makeText(this, "Ganaste perro", Toast.LENGTH_SHORT).show()
                    Thread.sleep(3000)
                }
            }
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

         posj2 += randonm
        fun mover(view: View?) {
            if (dado_player.isPressed) {
                posj2 += randonm
                var random = Random().nextInt(6) + 1
                if (turno == 0) {
                    //nueva posicion
                    posj1 += random
                    for (i in casillas) {
                        Toast.makeText(this, "Hynu avanza " + random + " casillas", Toast.LENGTH_SHORT).show()
                        //exacto una variable alien
                        hynu = casillas[posj1 - 1]
                        hynu.setImageResource(drawable.hynu)
                        dank.setImageResource(imgcasillas[posj2 - 1])
                    }
                    casilla_point()
                }
            }
        }
            fun mover2(view: View?){
            if (dado_maquina.isPressed) {
                posj1 += random
                var randonm = Random().nextInt(6) + 1
                if (turnom == 1) {
                    Toast.makeText(this, "Dank avanza "+randonm+" casillas", Toast.LENGTH_SHORT).show()
                    posj2 += randonm
                    for (i in casillas) {
                        //exacto una variable alien
                        dank = casillas[posj2 - 1]
                        dank.setImageResource(drawable.dank)
                        hynu.setImageResource(imgcasillas[posj1 - 1])

                    }
                }
            }
        }

        // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        fun get_img_primerlanzamiento() {
            random1 = Random().nextInt(6) + 1
            // start the animation
            primer_lanzamiento.startAnimation(animation)

            // now we will get when the animation starts and when it ends

            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    // when animation ends we will set the dice image
                    primer_lanzamiento.setImageResource(lanzamiento1.elementAt(random1)) // this will set the dice image randomly
                    // enable the button click
                    primer_lanzamiento.isEnabled = true
                }

                override fun onAnimationStart(p0: Animation?) {
                    // when animation starts we will set default dice image
                    primer_lanzamiento.setImageResource(lanzar)
                }
            })
        }

        // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------------------------------------------------------------------------

        fun get_img_dadoplayer() {
            var random = Random().nextInt(6) + 1
            // start the animation
            dado_player.startAnimation(animation)

            // now we will get when the animation starts and when it ends

            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    // when animation ends we will set the dice image
                    dado_player.setImageResource(diceImages.elementAt(random)) // this will set the dice image randomly
                    // enable the button click
                }

                override fun onAnimationStart(p0: Animation?) {
                    // when animation starts we will set default dice image
                    dado_player.setImageResource(lanzar)
                }
            })
        }

        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        fun get_img_dadomaquina() {
            var randonm = Random().nextInt(6) + 1
            // start the animation
            dado_maquina.startAnimation(animationm)

            // now we will get when the animation starts and when it ends

            animationm.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    // when animation ends we will set the dice image
                    dado_maquina.setImageResource(imgq.elementAt(randonm)) // this will set the dice image randomly
                    // enable the button
                }

                override fun onAnimationStart(p0: Animation?) {
                    // when animation starts we will set default dice image
                    dado_maquina.setImageResource(ml)
                }
            })
        }

        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        //volver a principal
        val btnatras = findViewById<ImageView>(id.s)
        btnatras.setOnClickListener {
            val es = Intent(this, principal::class.java)
            startActivity(es)
        }
        //volver a principal
        val btn_dadoplayer = findViewById<ImageView>(id.dado_player)
        btn_dadoplayer.setOnClickListener {
            get_img_dadoplayer()
            mover(hynu)
            QuitarDadoPlayer()
            get_img_dadomaquina()
            mover2(dank)
            QuitarDadoMaquina()
        }

        val ms = findViewById<ImageView>(R.id.musica)
        ms.setOnClickListener {
            val es = Intent(this, Musica::class.java)
            startActivity(es)
        }
        val aj = findViewById<ImageView>(R.id.ajustes)
        aj.setOnClickListener {
            val ajust = Intent(this, Ajustes::class.java)
            startActivity(ajust)
        }

        val btn_firstlanzamiento = findViewById<ImageView>(id.primer_lanzamiento)
        btn_firstlanzamiento.setOnClickListener {
            random1 = Random().nextInt(6) + 1
            get_img_primerlanzamiento()
            when (random1) {
                5 -> {
                    Toast.makeText(this, "Hynu saco 5 ahora podra salir", Toast.LENGTH_SHORT).show()
                    primer_lanzamiento.isVisible = false
                    dado_player.isVisible = true
                }
                else -> {
                    Toast.makeText(this, "Hynu necesita 5 para salir", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}




