package com.example.padelmatch_interficies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PartitAdapter(private val llistaPartits: MutableList<Partit>) :
    RecyclerView.Adapter<PartitAdapter.PartitViewHolder>() {
    class PartitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_nom_Club: TextView = itemView.findViewById(R.id.txt_nom_club)
        val txt_data_hora: TextView = itemView.findViewById(R.id.txt_data_hora)
        val txt_plazas: TextView = itemView.findViewById(R.id.txt_plazas)
        val txt_nivel: TextView = itemView.findViewById(R.id.txt_nivel)
        val btn_edit: Button = itemView.findViewById(R.id.btn_edit)
        val txt_posicion: TextView = itemView.findViewById(R.id.txt_posicion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_partit, parent, false)
        return PartitViewHolder(view)
    }

    override fun onBindViewHolder(holder: PartitViewHolder, position: Int) {
        val partit = llistaPartits[position]

        holder.txt_nom_Club.text = partit.club
        holder.txt_data_hora.text = partit.horario
        holder.txt_nivel.text = partit.nivel
        holder.txt_plazas.text = partit.plazas
        holder.txt_posicion.text = "Posición · ${partit.posicion}"


    }

    override fun getItemCount(): Int = llistaPartits.size
    fun afegirPartit(nouPartit: Partit) {
        llistaPartits.add(nouPartit)
        notifyItemInserted(llistaPartits.size - 1)
        Log.d("PadelMatchDebug", "Nou partit afegit: ${nouPartit.club}")
    }
}