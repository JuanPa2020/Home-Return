package com.example.prueba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.*
import com.example.prueba.R.*
import com.example.prueba.R.drawable.*
import kotlinx.android.synthetic.main.activity_escalera.*
import java.util.*
import kotlin.math.log
import kotlin.math.log2


class Escalera : AppCompatActivity() {

    lateinit var hynu: ImageView
    lateinit var dank: ImageView
    lateinit var animation: Animation
    lateinit var animationm: Animation

    //posicion en el tablero
    var posj1 = -1
    var posj2 = -1

    //turno de cada jugador
    var turno = 0
    //jugador
    var random = dado()
    var random1 = dado()
    var turnom = 1

    val casillas: List<ImageView> by lazy {
        listOf<ImageView>(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30)
    }
    val imgcasillas by lazy {
        listOf(casilla1, casilla2, casilla3, casiilla4, casilla5, casilla6, casilla7, casilla8, casilla9, casilla10, casilla11, casilla12, casilla13, casilla14, agujero1, casilla16, casilla17, casilla18, casilla19, nave, casilla21, casilla22, casilla23, casilla24, casilla25, agujero2, casilla27, casilla28, casilla29, casilla30)
    }
    val diceImages by lazy {
        listOf(d1, d2, d3, d4, d5, d6)
    }
    val imgq by lazy { listOf(m1, m2, m3, m4, m5, m6) }
    /*val lanzamiento1 = mutableListOf(d1, d2, d3, d4, d5, d6)*/

    fun dado():Int{

        var random =Random().nextInt(1) + 1
        Log.d("MiLog", random.toString())
        return random
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    fun QuitarDadoMaquina() {
        dado_player.isEnabled = true
        dado_maquina.isEnabled = false
        Log.d("QuitarDadoMaq", dado_player.toString())
        Log.d("QuitarDadoMaq", dado_maquina.toString())
    }

    fun QuitarDadoPlayer() {
        dado_player.isEnabled = false
        dado_maquina.isEnabled = true
        Log.d("QuitarDadopla", dado_player.toString())
        Log.d("QuitarDadopla", dado_maquina.toString())

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    fun casilla_point() {
        when (posj1 + 1) {
            2 -> {
                val pop1 = Intent(this, Popup_p1::class.java)
                Toast.makeText(this, "Caiste en el planeta Dankn", Toast.LENGTH_SHORT).show()
                startActivityForResult(pop1, 1)
            }
            7 -> {
                val p2 = Intent(this, Popup_p2::class.java)
                Toast.makeText(this, "Caiste en el planeta Dankn", Toast.LENGTH_SHORT).show()
                startActivityForResult(p2, 1)
                Thread.sleep(3000)
            }
            13 -> {
                val pop3 = Intent(this, Popup_p3::class.java)
                startActivityForResult(pop3, 1)
                Thread.sleep(3000)
            }
            15 -> {
                val pop4 = Intent(this, Popup_p4::class.java)
                startActivityForResult(pop4, 1)
                Thread.sleep(3000)
            }
            20 -> {
                val pop5 = Intent(this, Popup_p5::class.java)
                startActivityForResult(pop5, 1)
                Thread.sleep(3000)
            }
            26 -> {
                val pop6 = Intent(this, Popup_p6::class.java)
                startActivityForResult(pop6, 1)
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
    fun mover(moverplayer:Boolean, avanzar_casillas:Int) {
        if (moverplayer) {
            if (turno == 0) {
                //nueva posicion
                Toast.makeText(this, "Hynu avanza " + avanzar_casillas + " casillas", Toast.LENGTH_SHORT).show()
                posj1 += avanzar_casillas
                Log.d("posicion_actual", posj1.toString())
                for (i in casillas) {
                    //exacto una variable alien
                    hynu = casillas[posj1]
                    hynu.setImageResource(drawable.hynu)
                    if(posj2!=-1) {
                        //dank.setImageResource(imgcasillas[posj2])
                    }
                }
                casilla_point()
            }
        } else {
            if (turnom == 1) {
                //nueva posicion
                posj2 += avanzar_casillas
                Toast.makeText(this, "Dank avanza "+avanzar_casillas+" casillas", Toast.LENGTH_SHORT).show()
                /*Toast.makeText(this, "Dank te alcanzo retrosede 3 casilla", Toast.LENGTH_SHORT).show()*/
                for (i in casillas) {
                    //exacto una variable alien
                    dank = casillas[posj2]
                    dank.setImageResource(drawable.dank)
                    if(posj1!=-1) {
                        //hynu.setImageResource(imgcasillas[posj1])
                    }
                }
                /*if(casillas[posj2 - 1]  == casillas[posj1 - 1]   ) {
                    hynu = casillas[posj1 + 3]
                    hynu.setImageResource(drawable.hynu)



                }*/
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*
    fun get_img_primerlanzamiento() {
        random1=dado()
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
    */
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------

    fun get_img_dadoplayer() {
        random=dado()
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
        // start the animation
        dado_player.startAnimation(animation)
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    fun get_img_dadomaquina() {
        random1 = dado()
        // start the animation


        // now we will get when the animation starts and when it ends

        animationm.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                // when animation ends we will set the dice image

                dado_maquina.setImageResource(imgq.elementAt(random1)) // this will set the dice image randomly
                // enable the button
            }

            override fun onAnimationStart(p0: Animation?) {
                // when animation starts we will set default dice image
                dado_maquina.setImageResource(ml)
            }
        })

        dado_maquina.startAnimation(animationm)
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    // metodo que valida la respuesta de los popup y hace avanzar o retroceder casillas
    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val respuesta_correcta = data?.getBooleanExtra("result", false)
            if(respuesta_correcta == true) {
                mover(moverplayer = true, avanzar_casillas = 1)
            } else {
                mover(moverplayer = true, avanzar_casillas = -1)
            }
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_escalera)

         hynu = findViewById(id.hynu)
         dank = findViewById(id.dank)


        // initialize the animation
        animation = AnimationUtils.loadAnimation(this@Escalera, anim.shake_anim)

        // initialize the animation
        animationm = AnimationUtils.loadAnimation(this@Escalera, anim.pepe)


        //volver a principal
        val btnatras = findViewById<ImageView>(id.s)
        btnatras.setOnClickListener {
            val es = Intent(this, principal::class.java)
            startActivity(es)
        }
        //volver a principal
        val btn_dadoplayer = findViewById<ImageView>(id.dado_player)
        btn_dadoplayer.setOnClickListener {
            get_img_dadoplayer ()
            mover(moverplayer = true, avanzar_casillas = random)
            QuitarDadoPlayer()
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
        //volver a principal
        val btn_dadomaquina = findViewById<ImageView>(id.dado_maquina)
        btn_dadomaquina.setOnClickListener {
            get_img_dadomaquina()
            mover(moverplayer = false, avanzar_casillas = random1)
            QuitarDadoMaquina()
        }
        /*val btn_firstlanzamiento = findViewById<ImageView>(id.primer_lanzamiento)
        btn_firstlanzamiento.setOnClickListener {
            random1 = Random().nextInt(5) + 1
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
        }*/

    }
}






