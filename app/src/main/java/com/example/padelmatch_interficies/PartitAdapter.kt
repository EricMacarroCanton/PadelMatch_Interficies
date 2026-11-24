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
        val txtNomClub: TextView = itemView.findViewById(R.id.txt_nom_club)
        val txtDataHora: TextView = itemView.findViewById(R.id.txt_data_hora)
        val txtPlazas: TextView = itemView.findViewById(R.id.txt_plazas)
        val txtNivel: TextView = itemView.findViewById(R.id.txt_nivel)
        val btnEdit: Button = itemView.findViewById(R.id.btn_edit)
        val txtPosicion: TextView = itemView.findViewById(R.id.txt_posicion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_partit, parent, false)
        return PartitViewHolder(view)
    }

    override fun onBindViewHolder(holder: PartitViewHolder, position: Int) {
        val partit = llistaPartits[position]
        holder.txtNomClub.text = partit.club
        holder.txtDataHora.text = partit.horario
        holder.txtNivel.text = partit.nivel
        holder.txtPlazas.text = partit.plazas
        holder.txtPosicion.text = "Posición ${partit.posicion}"

        holder.btnEdit.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                Log.d("PadelMatchDebug", "Unido al partido en posición $pos: ${partit.club}")
                Toast.makeText(
                    holder.itemView.context,
                    "Te has unido a ${partit.club}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int = llistaPartits.size

    fun afegirPartit(nouPartit: Partit) {
        llistaPartits.add(nouPartit)
        notifyItemInserted(llistaPartits.size - 1)
        Log.d("PadelMatchDebug", "Nou partit afegit: ${nouPartit.club}")
    }
}