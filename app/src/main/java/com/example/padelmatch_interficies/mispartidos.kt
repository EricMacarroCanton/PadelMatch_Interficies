package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class mispartidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mispartidos)

        val layoutFiltro = findViewById<LinearLayout>(R.id.layoutFiltro)
        layoutFiltro?.setOnClickListener {
            val intent = Intent(this, filtro::class.java)
            startActivity(intent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        bottomNav.selectedItemId = R.id.nav_mis_partidos
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_partidos -> {
                    val intent = Intent(this, pantalla_partits::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_mis_partidos -> true
                R.id.nav_configuracion -> {
                    val intent = Intent(this, activity_settings::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val recyclerProximos = findViewById<RecyclerView>(R.id.recyclerMisPartidosProximos)
        recyclerProximos.layoutManager = LinearLayoutManager(this)
        val llistaProximos = mutableListOf(
            Partit("Padel Indoor Badalona", "JUEVES 20:00 21:30", "Plazas 4/4", "NVL 4.0", "INSCRITO", "Drive")
        )
        recyclerProximos.adapter = MisPartidosAdapter(llistaProximos)

        val recyclerAnteriores = findViewById<RecyclerView>(R.id.recyclerMisPartidosAnteriores)
        recyclerAnteriores.layoutManager = LinearLayoutManager(this)
        val llistaAnteriores = mutableListOf(
            Partit("BCN Padel Club", "PASADO 10:00 11:30", "Plazas 4/4", "NVL 3.5", "ACABADO", "Drive")
        )
        recyclerAnteriores.adapter = MisPartidosAdapter(llistaAnteriores)
    }
}