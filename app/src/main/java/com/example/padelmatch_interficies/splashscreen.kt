package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val imgLogo = findViewById<ImageView>(R.id.imgLogo)

        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        imgLogo.startAnimation(animation)

        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLoggedIn) {
                val intent = Intent(this, pantalla_partits::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, login::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)
    }
}