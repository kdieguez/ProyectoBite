package com.example.proyectobyte

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class StatementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_statement)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Recibir el usuario
        val usuario = intent.getStringExtra(EXTRA_USUARIO) ?: ""

//        Mostrar bienvenida
        val tvBienvenido = findViewById<TextView>(R.id.tvBienvenido)
        tvBienvenido.text = getString(R.string.bienvenido, usuario)

//         Botón Confirmar y regresar
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        btnConfirmar.setOnClickListener {
            finish()
        }

//         Logout
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.action_logout) {
                finish()
                true
            } else {
                false
            }
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragment, FragmentStatement())
                .commit()
        }
    }
    companion object {
        const val EXTRA_USUARIO = "EXTRA_USUARIO"
    }
}