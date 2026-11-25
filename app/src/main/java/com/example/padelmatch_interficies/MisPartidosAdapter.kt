package com.example.padelmatch_interficies

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MisPartidosAdapter(private val llistaPartits: MutableList<Partit>) :
    RecyclerView.Adapter<MisPartidosAdapter.MisPartidosViewHolder>() {

    class MisPartidosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNomClub: TextView = itemView.findViewById(R.id.txt_nom_club)
        val txtEstado: TextView = itemView.findViewById(R.id.txt_estado)
        val txtDataHora: TextView = itemView.findViewById(R.id.txt_data_hora)
        val txtPlazas: TextView = itemView.findViewById(R.id.txt_plazas)
        val txtPosicion: TextView = itemView.findViewById(R.id.txt_posicion)
        val btnEdit: Button = itemView.findViewById(R.id.btn_edit)
        val btnCancelar: Button = itemView.findViewById(R.id.btn_remove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MisPartidosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_mispartidos, parent, false)
        return MisPartidosViewHolder(view)
    }

    override fun onBindViewHolder(holder: MisPartidosViewHolder, position: Int) {
        val partit = llistaPartits[position]
        holder.txtNomClub.text = partit.club
        holder.txtEstado.text = partit.estado
        holder.txtDataHora.text = partit.horario
        holder.txtPlazas.text = partit.plazas
        holder.txtPosicion.text = "Posición ${partit.posicion}"

        holder.btnEdit.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                Log.d("PadelMatchDebug", "Modificado elemento a la posición $pos")
                Toast.makeText(
                    holder.itemView.context,
                    "Editando ${partit.club}",
                    Toast.LENGTH_SHORT
                ).show()
                val context = holder.itemView.context
                val intent = Intent(context, activity_crearpartit::class.java)
                intent.putExtra("club", partit.club)
                intent.putExtra("horario", partit.horario)
                intent.putExtra("modo_edicio", true)
                context.startActivity(intent)
            }
        }

        holder.btnCancelar.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                val partitEliminat = llistaPartits[pos]
                llistaPartits.removeAt(pos)
                notifyItemRemoved(pos)
                Log.d("PadelMatchDebug", "Eliminado elemento a la posición $pos: ${partitEliminat.club}")
                Toast.makeText(
                    holder.itemView.context,
                    "Partido cancelado: ${partitEliminat.club}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int = llistaPartits.size
}