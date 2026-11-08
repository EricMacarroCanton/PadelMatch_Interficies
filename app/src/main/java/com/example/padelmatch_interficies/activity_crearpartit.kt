package com.example.padelmatch_interficies

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class activity_crearpartit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearpartit)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val btnSaveMatch = findViewById<Button>(R.id.btnSaveMatch)

        btnBack?.setOnClickListener {
            finish()
        }

        btnCancel?.setOnClickListener {
            finish()
        }

        btnSaveMatch?.setOnClickListener {
            finish()
        }
    }
}