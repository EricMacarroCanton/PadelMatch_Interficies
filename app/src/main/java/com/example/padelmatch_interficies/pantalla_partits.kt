package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class pantalla_partits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_partits)

        val layoutFiltro = findViewById<LinearLayout>(R.id.layoutFiltro)
        layoutFiltro?.setOnClickListener {
            val intent = Intent(this, filtro::class.java)
            startActivity(intent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        bottomNav?.selectedItemId = R.id.nav_partidos
        bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_partidos -> true
                R.id.nav_mis_partidos -> {
                    val intent = Intent(this, mispartidos::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_configuracion -> {
                    val intent = Intent(this, activity_settings::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val fabAddMatch = findViewById<FloatingActionButton>(R.id.fab_add_match)
        fabAddMatch?.setOnClickListener {
            val intent = Intent(this@pantalla_partits, activity_crearpartit::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPartits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val llistaDeProva = mutableListOf(
            Partit("Nick Padel Club", "HOY 18:30 20:00", "Plazas 4/4", "NVL 3.5", "Confirmado", "Drive"),
            Partit("FairPlay Padel Club", "MAÑANA 16:30 17:00", "Plazas 3/4", "NVL 4.0", "Pendiente", "Revés")
        )
        recyclerView.adapter = PartitAdapter(llistaDeProva)
    }
}