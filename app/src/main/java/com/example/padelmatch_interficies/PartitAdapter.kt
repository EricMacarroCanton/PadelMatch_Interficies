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
        val txtClub: TextView = itemView.findViewById(R.id.txtClub)
        val txtHorari: TextView = itemView.findViewById(R.id.txtHorari)
        val btnModificar: Button = itemView.findViewById(R.id.btnModificar)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_partit, parent, false)
        return PartitViewHolder(view)
    }

    override fun onBindViewHolder(holder: PartitViewHolder, position: Int) {
        val partit = llistaPartits[position]

        holder.txtClub.text = partit.club
        holder.txtHorari.text = partit.horari

        holder.btnModificar.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Modificant: ${partit.club}",
                Toast.LENGTH_SHORT
            ).show()
            Log.d("PadelMatchDebug", "Modificat element a la posició $position")
        }
    }
}