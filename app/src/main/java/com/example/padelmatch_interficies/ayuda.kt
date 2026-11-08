package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ayuda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        val btnEnrere = findViewById<ImageButton>(R.id.btn_enrere)
        btnEnrere.setOnClickListener {
            val intent = Intent(this, activity_settings::class.java)
            startActivity(intent)
            finish()
        }
    }
}