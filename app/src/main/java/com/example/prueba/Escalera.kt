package com.example.prueba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.prueba.*
import com.example.prueba.R.*
import com.example.prueba.R.drawable.*
import kotlinx.android.synthetic.main.activity_escalera.*
import java.util.*
import kotlin.concurrent.thread
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

    //randoms
    var random = dado()
    var random1 = dado()
    var random2 = dado()

    val casillas by lazy {
        listOf(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31)
    }

    val lanzamiento1 by lazy {
        listOf(d1, d2, d3, d4, d5, d6)
    }
    val diceImages by lazy {
        listOf(d1, d2, d3, d4, d5, d6)
    }
    val imgq by lazy {
        listOf(m1, m2, m3, m4, m5, m6)
    }

    fun dado():Int{

        var random =Random().nextInt(6) + 1
        Log.d("MiLog", random.toString())
        return random
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    fun QuitarDadoplayer() {
        dado_maquina.isVisible= true
        dado_player.isVisible=false
        Log.d("QuitarDadoMaq", dado_player.toString())
        Log.d("QuitarDadoMaq", dado_maquina.toString())
    }

    fun QuitarDadoMaquina() {
        dado_maquina.isVisible= false
        dado_player.isVisible=true
        dado_player.isEnabled=true
        Log.d("QuitarDadoMaq", dado_player.toString())
        Log.d("QuitarDadoMaq", dado_maquina.toString())
    }


    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    fun casilla_point() {
        dado_player.isEnabled=true
        when (posj1 + 1) {
            2 -> {
                val pop1 = Intent(this, Popup_p1::class.java)
                Toast.makeText(this, "Caiste en el planeta Dankn", Toast.LENGTH_SHORT).show()
                startActivityForResult(pop1, 0)
                hynu.setImageResource(drawable.transparente)

            }
            7 -> {
                val p2 = Intent(this, Popup_p2::class.java)
                Toast.makeText(this, "Caiste en el planeta Dankn", Toast.LENGTH_SHORT).show()
                startActivityForResult(p2, 1)
                hynu.setImageResource(drawable.transparente)

            }
            13 -> {
                val pop3 = Intent(this, Popup_p3::class.java)
                startActivityForResult(pop3,1)
                hynu.setImageResource(drawable.transparente)
            }
            15 -> {
                val pop4 = Intent(this, Popup_p4::class.java)
                startActivityForResult(pop4, 1)
                hynu.setImageResource(drawable.transparente)

            }
            20 -> {
                val pop5 = Intent(this, Popup_p5::class.java)
                startActivityForResult(pop5, 1)
                hynu.setImageResource(drawable.transparente)

            }
            26 -> {
                val pop6 = Intent(this, Popup_p6::class.java)
                startActivityForResult(pop6, 1)
                hynu.setImageResource(drawable.transparente)

            }
            31 -> {
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show()
                dado_maquina.isVisible=false
                dado_player.isVisible=false

            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    fun mover(moverplayer:Boolean, avanzar_casillas:Int) {
        dado_player.isEnabled=false
        if (moverplayer) {
            //nueva posicion
            Toast.makeText(this, "Hynu avanza " + avanzar_casillas + " casillas", Toast.LENGTH_SHORT).show()
            posj1 += avanzar_casillas
            Log.d("posicion_actual", posj1.toString())
            if(dado_player.isPressed && posj1!=-1) {
                //devulevo la posicion de la escalera es decir ahi estaba hynu y me va a devolver donde
                    // estaba hynu el numerito de la escalera.
                hynu.setImageResource(drawable.transparente)
            }
            for (i in casillas) {
                //en la posicion del vector se asigna a hynu(imagen) dependiendo donde caiga.
                hynu=casillas[posj1]
                hynu.setImageResource(drawable.hynu)
            }

            Handler(Looper.getMainLooper()).postDelayed({
                casilla_point()
            }, 2000)

        } else {
            //nueva posicion
            posj2 += avanzar_casillas
            Toast.makeText(this, "Dank avanza "+avanzar_casillas+" casillas", Toast.LENGTH_SHORT).show()
            /*Toast.makeText(this, "Dank te alcanzo retrosede 3 casilla", Toast.LENGTH_SHORT).show()*/
            if( posj2!=-1) {
                //devulevo la posicion de la escalera es decir ahi estaba hynu
                    // y me va a devolver donde estaba hynu el numerito de la escalera.
                dank.setImageResource(drawable.transparente)
            }
            for (i in casillas) {
                //en la posicion del vector se asigna a dank(imagen) dependiendo donde caiga ps.
                dank = casillas[posj2]
                dank.setImageResource(drawable.dank)

            }
            /* //Profe como poner un casillas[posj1-1] == con casillas[2:29]
             if(casillas[posj2 - 1]  == casillas[posj1 - 1]   ) {
                 if(casillas[posj1-1]==casillas[2] || casillas[posj1-1]==casillas[3]){
                     hynu = casillas[posj1 -1]
                     hynu.setImageResource(drawable.hynu)
                 }

             }*/
            }

    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    fun get_img_primerlanzamiento() {
        random2=dado()

        // now we will get when the animation starts and when it ends
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                // when animation ends we will set the dice image
                primer_lanzamiento.setImageResource(lanzamiento1.elementAt(random2-1)) // this will set the dice image randomly
                // enable the button click
                primer_lanzamiento.isEnabled = true
            }

            override fun onAnimationStart(p0: Animation?) {
                // when animation starts we will set default dice image
                primer_lanzamiento.setImageResource(lanzar)
            }
        })
        primer_lanzamiento.startAnimation(animation)
    }

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
                dado_player.setImageResource(diceImages.elementAt(random-1)) // this will set the dice image randomly
                // enable the button click
            }

            override fun onAnimationStart(p0: Animation?) {
                // when animation starts we will set default dice image
                dado_player.setImageResource(lanzar)
            }
        })
        // start the animation
        dado_player.startAnimation(animation)
        Handler(Looper.getMainLooper()).postDelayed({
            QuitarDadoplayer()
        }, 3000)
        get_img_dadomaquina()
        Handler(Looper.getMainLooper()).postDelayed({
            QuitarDadoMaquina()
        }, 6000)


    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    fun get_img_dadomaquina() {
        random1 = dado()

        animationm.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                // when animation ends we will set the dice image

                dado_maquina.setImageResource(imgq.elementAt(random1-1)) // this will set the dice image randomly
                // enable the button
            }

            override fun onAnimationStart(p0: Animation?) {
                // when animation starts we will set default dice image
                dado_maquina.setImageResource(ml)
            }
        })

        Handler(Looper.getMainLooper()).postDelayed({
            dado_maquina.startAnimation(animationm)
        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            mover(moverplayer = false, avanzar_casillas = random1)
        }, 3000)



    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    // metodo que valida la respuesta de los popup y hace avanzar o retroceder casillas
    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==0){
            val respuesta_incorrecta = data?.getBooleanExtra("result", false)
            val respuesta_correcta = data?.getBooleanExtra("result", true)
            if(respuesta_correcta == true) {
                mover(moverplayer = true, avanzar_casillas = 3)
            } else if (respuesta_incorrecta==false){
                mover(moverplayer = true, avanzar_casillas = -1)
            }
        }
        if (requestCode == 1) {
            val respuesta_incorrecta = data?.getBooleanExtra("result", false)
            val respuesta_correcta = data?.getBooleanExtra("result", true)
            if(respuesta_correcta == true) {
                mover(moverplayer = true, avanzar_casillas = 3)
            } else if (respuesta_incorrecta==false){
                mover(moverplayer = true, avanzar_casillas = -3)
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

            val dentroDelMapa= posj1 + random <= 31
            if (dentroDelMapa){
                get_img_dadoplayer()
                mover(moverplayer = true, avanzar_casillas = random)
            }
            else{
                Toast.makeText(this, "Ganaste ", Toast.LENGTH_SHORT).show()
            }

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

        val btn_firstlanzamiento = findViewById<ImageView>(id.primer_lanzamiento)
        btn_firstlanzamiento.setOnClickListener {
            get_img_primerlanzamiento()
            when (random2) {
                5-> {
                    Toast.makeText(this, " Haz sacado 5 ahora podras salir", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        primer_lanzamiento.isVisible = false
                        dado_player.isVisible = true
                        dado_maquina.isVisible= false

                    }, 3000)

                }
                else -> {
                    Toast.makeText(this, " Necesitas 5 para salir", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }
}






