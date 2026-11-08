package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class filtro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filtro)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnApplyFilters = findViewById<MaterialButton>(R.id.btnApplyFilters)
        btnApplyFilters.setOnClickListener {
            val intent = Intent(this, pantalla_partits::class.java)
            startActivity(intent)
            finish()

            val btnCerrarFiltro = findViewById<ImageButton>(R.id.btnCerrarFiltro)
            btnCerrarFiltro?.setOnClickListener {
                val intent = Intent(this, pantalla_partits::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}