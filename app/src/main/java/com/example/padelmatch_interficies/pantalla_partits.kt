package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class pantalla_partits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_partits)

        val layoutFiltro = findViewById<LinearLayout>(R.id.layoutFiltro)
        layoutFiltro.setOnClickListener {
            val intent = Intent(this, filtro::class.java)
            startActivity(intent)
        }

        val tabMisPartidos = findViewById<LinearLayout>(R.id.tab_mispartidos)
        tabMisPartidos.setOnClickListener {
            val intent = Intent(this, mispartidos::class.java)
            startActivity(intent)
        }

        val tabConfiguracion = findViewById<LinearLayout>(R.id.tab_configuracion)
        tabConfiguracion.setOnClickListener {
            val intent = Intent(this, activity_settings::class.java)
            startActivity(intent)
        }

        val fabAddMatch = findViewById<FloatingActionButton>(R.id.fab_add_match)
        fabAddMatch?.setOnClickListener {
            val intent = Intent(this@pantalla_partits, activity_crearpartit::class.java)
            startActivity(intent)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPartits)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val llistaDeProva = mutableListOf(
            Partit("Nick Padel Club", "HOY · 18:30 - 20:00", "Places · 4/4", "NVL 3.5", "Confirmado", "Drive"),
            Partit("FairPlay Padel Club", "MAÑANA · 16:30 - 17:00", "Places · 3/4", "NVL 4.0", "Pendiente", "Revés")
        )

        recyclerView.adapter = PartitAdapter(llistaDeProva)
    }
}