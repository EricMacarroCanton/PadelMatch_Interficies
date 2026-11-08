package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class mispartidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mispartidos)

        val layoutFiltro = findViewById<LinearLayout>(R.id.layoutFiltro)
        layoutFiltro?.setOnClickListener {
            val intent = Intent(this, filtro::class.java)
            startActivity(intent)
        }

        val tabCuadricula = findViewById<LinearLayout>(R.id.tab_cuadricula)
        tabCuadricula?.setOnClickListener {
            val intent = Intent(this, pantalla_partits::class.java)
            startActivity(intent)
            finish()
        }

        val tabConfiguracion = findViewById<LinearLayout>(R.id.tab_configuracion)
        tabConfiguracion.setOnClickListener {
            val intent = Intent(this, activity_settings::class.java)
            startActivity(intent)
        }
    }
}