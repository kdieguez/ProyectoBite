package com.example.proyectobite

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class FragmentStatement : Fragment(R.layout.fragment_statement) {

    private val adapter = MovimientoAdapter(emptyList())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rvMovimientos)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val respuesta = RetrofitClient.api.obtenerMovimientos()
                adapter.actualizar(respuesta.statement)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), R.string.error_carga, Toast.LENGTH_LONG).show()
            }
        }
    }
}