package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.*


class Escalera : AppCompatActivity() {

    // variables dado
    private lateinit var imgDice: ImageView
    private val diceImages = mutableListOf<Int>()
    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escalera)
        imgDice = findViewById(R.id.ImageView)
        val btnRoll = findViewById<ImageView>(R.id.ImageView)
        btnRoll.setOnClickListener {
            // disable the button click
            btnRoll.isEnabled = false
            getRandomValue()
        }

        //volver a principal
        val btnes= findViewById<ImageView>(R.id.btnatras)
        btnes.setOnClickListener {
            val es = Intent(this, principal::class.java)
            startActivity(es)
        }

        //M
        val pregunta1= findViewById<ImageView>(R.id.c2)
        pregunta1.setOnClickListener {
            val pop1= Intent(this, Popup_p1::class.java)
            startActivity(pop1)
        }

        val pregunta2= findViewById<ImageView>(R.id.c7)
        pregunta2.setOnClickListener {
            val pop2= Intent(this, Popup_p2::class.java)
            startActivity(pop2)
        }
        // add dice images to list
        diceImages.add(R.drawable.d1)
        diceImages.add(R.drawable.d2)
        diceImages.add(R.drawable.d3)
        diceImages.add(R.drawable.d4)
        diceImages.add(R.drawable.d5)
        diceImages.add(R.drawable.d6)

        // initialize the animation
        animation = AnimationUtils.loadAnimation(this@Escalera, R.anim.shake_anim)

    }

    private fun getRandomValue() {
        val random = Random().nextInt(6) // returns number between 0-5

        // start the animation
        imgDice.startAnimation(animation)

        // now we will get when the animation starts and when it ends

        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                // when animation ends we will set the dice image
                imgDice.setImageResource(diceImages.elementAt(random)) // this will set the dice image randomly
                // enable the button click
                imgDice.isEnabled = true
            }

            override fun onAnimationStart(p0: Animation?) {
                // when animation starts we will set default dice image
                imgDice.setImageResource(R.drawable.lanzar)
            }
        })
    }

    fun bloquear_dado(view: View) {
        imgDice.isVisible = false
    }

    fun mostrar_dado(view: View) {
        imgDice.isVisible = true
    }
}

