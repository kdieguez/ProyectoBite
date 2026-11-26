package com.example.proyectobyte

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

class MovimientoAdapter(private var lista: List<Movimiento>) :
    RecyclerView.Adapter<MovimientoAdapter.ViewHolder>() {

    // Guardar referencias a las vistas
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDescripcion: TextView = view.findViewById(R.id.tvDescripcion)
        val tvFecha: TextView = view.findViewById(R.id.tvFecha)
        val tvMonto: TextView = view.findViewById(R.id.tvMonto)
    }

    // Crear una fila nueva
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movimiento, parent, false)
        return ViewHolder(vista)
    }

    // Llenar filas con los datos de la posición indicada
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mov = lista[position]
        val contexto = holder.itemView.context

        holder.tvDescripcion.text = mov.description
        holder.tvFecha.text = formatearFecha(mov.date)

        val monto = String.format(Locale.US, "%,.2f", mov.amount.toDoubleOrNull() ?: 0.0)

        if (mov.type == "DEBIT") {
            holder.tvMonto.text = "- $ $monto"
            holder.tvMonto.setTextColor(ContextCompat.getColor(contexto, R.color.debit))
        } else {
            holder.tvMonto.text = "+ $ $monto"
            holder.tvMonto.setTextColor(ContextCompat.getColor(contexto, R.color.credit))
        }
    }

    // Número de filas
    override fun getItemCount(): Int = lista.size

    fun actualizar(nuevaLista: List<Movimiento>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }

    private fun formatearFecha(fecha: String): String {
        return try {
            val entrada = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
            val salida = SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale.US)
            salida.format(entrada.parse(fecha)!!)
        } catch (e: Exception) {
            fecha
        }
    }
}