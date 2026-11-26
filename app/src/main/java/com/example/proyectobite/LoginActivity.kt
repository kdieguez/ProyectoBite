package com.example.proyectobite

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val vistaPrincipal = findViewById<View>(R.id.main)
        val paddingIzq = vistaPrincipal.paddingLeft
        val paddingArriba = vistaPrincipal.paddingTop
        val paddingDer = vistaPrincipal.paddingRight
        val paddingAbajo = vistaPrincipal.paddingBottom
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(paddingIzq + systemBars.left, paddingArriba + systemBars.top, paddingDer + systemBars.right, paddingAbajo + systemBars.bottom)
            insets
        }
        val etUsuario = findViewById<TextInputEditText>(R.id.etUsuario)
        val etContrasena = findViewById<TextInputEditText>(R.id.etContrasena)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val contrasena = etContrasena.text.toString()

            when {
                usuario.isEmpty() || contrasena.isEmpty() -> mostrarAlerta(R.string.error_campos_vacios)
                usuario.length < 8 -> mostrarAlerta(R.string.error_usuario_corto)
                contrasena.length < 6 -> mostrarAlerta(R.string.error_contrasena_corta)
                else -> {
                    val intent = Intent(this, StatementActivity::class.java)
                    intent.putExtra(StatementActivity.EXTRA_USUARIO, usuario)
                    startActivity(intent)
                }
            }
        }
    }
    private fun mostrarAlerta(mensaje: Int) {
        AlertDialog.Builder(this)
            .setTitle(R.string.titulo_alerta)
            .setMessage(mensaje)
            .setPositiveButton(R.string.btn_aceptar, null)
            .show()
    }
}