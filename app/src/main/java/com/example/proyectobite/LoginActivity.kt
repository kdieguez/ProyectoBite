package com.example.proyectobite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View

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
    }
}