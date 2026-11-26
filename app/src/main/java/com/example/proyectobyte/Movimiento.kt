package com.example.proyectobyte
data class Movimiento(
    val description: String,
    val date: String,
    val amount: String,
    val type: String,
    val currency: String
)

data class StatementResponse(
    val statement: List<Movimiento>
)