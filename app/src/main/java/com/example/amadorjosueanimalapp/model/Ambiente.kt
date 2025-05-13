// Ambiente.kt
package com.example.amadorjosueanimalapp.model

data class Ambiente(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val facts: List<String> = emptyList() // Hechos
)