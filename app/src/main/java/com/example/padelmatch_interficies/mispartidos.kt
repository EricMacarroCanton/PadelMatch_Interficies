package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        tabConfiguracion?.setOnClickListener {
            val intent = Intent(this, activity_settings::class.java)
            startActivity(intent)
        }

        val recyclerProximos = findViewById<RecyclerView>(R.id.recyclerMisPartidosProximos)
        recyclerProximos.layoutManager = LinearLayoutManager(this)

        val llistaProximos = mutableListOf(
            Partit("Padel Indoor Badalona", "DIJOUS · 20:00 - 21:30", "Places · 4/4", "NVL 4.0", "Inscrit", "Drive")
        )
        recyclerProximos.adapter = MisPartidosAdapter(llistaProximos)

        val recyclerAnteriores = findViewById<RecyclerView>(R.id.recyclerMisPartidosAnteriores)
        recyclerAnteriores.layoutManager = LinearLayoutManager(this)

        val llistaAnteriores = mutableListOf(
            Partit("BCN Padel Club", "PASSAT · 10:00 - 11:30", "Places · 4/4", "NVL 3.5", "Finalitzat", "Drives")
        )
        recyclerAnteriores.adapter = MisPartidosAdapter(llistaAnteriores)
    }
}