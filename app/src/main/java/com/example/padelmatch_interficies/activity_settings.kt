package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class activity_settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnHelp = findViewById<Button>(R.id.btnGoToHelp)
        btnHelp?.setOnClickListener {
            val intent = Intent(this, ayuda::class.java)
            startActivity(intent)
        }

        val btnSave = findViewById<Button>(R.id.btnSavePreferences)
        btnSave?.setOnClickListener {
            val intent = Intent(this@activity_settings, pantalla_partits::class.java)
            startActivity(intent)
            finish()
        }
    }
}