package com.example.padelmatch_interficies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class MisPartidosAdapter(private val llistaPartits: MutableList<Partit>) :
    RecyclerView.Adapter<MisPartidosAdapter.MisPartidosViewHolder>() {

    class MisPartidosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_nom_Club: TextView = itemView.findViewById(R.id.txt_nom_club)
        val txt_estado: TextView = itemView.findViewById(R.id.txt_estado)
        val txt_data_hora: TextView = itemView.findViewById(R.id.txt_data_hora)
        val txt_plazas: TextView = itemView.findViewById(R.id.txt_plazas)
        val txt_posicion: TextView = itemView.findViewById(R.id.txt_posicion)
        val btn_edit: Button = itemView.findViewById(R.id.btn_edit)
        val btn_cancelar: Button = itemView.findViewById(R.id.btn_remove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MisPartidosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_mispartidos, parent, false)
        return MisPartidosViewHolder(view)
    }

    override fun onBindViewHolder(holder: MisPartidosViewHolder, position: Int) {
        val partit = llistaPartits[position]

        holder.txt_nom_Club.text = partit.club
        holder.txt_data_hora.text = partit.horari
        holder.txt_plazas.text = partit.places
        holder.txt_posicion.text = "Posició · ${partit.posicion}"

        holder.btn_edit.setOnClickListener {
            Log.d("PadelMatchDebug", "Modificat element a la posició $position")

            val context = holder.itemView.context
            val intent = Intent(context, activity_crearpartit::class.java)
            intent.putExtra("club", partit.club)
            intent.putExtra("horari", partit.horari)
            intent.putExtra("mode_edicio", true)
            context.startActivity(intent)
        }

        holder.btn_cancelar.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                val partitEliminat = llistaPartits[pos]
                llistaPartits.removeAt(pos)
                notifyItemRemoved(pos)

                Toast.makeText(
                    holder.itemView.context,
                    "Partit cancel·lat: ${partitEliminat.club}",
                    Toast.LENGTH_SHORT)
            }
        }
    }

    override fun getItemCount(): Int = llistaPartits.size
}