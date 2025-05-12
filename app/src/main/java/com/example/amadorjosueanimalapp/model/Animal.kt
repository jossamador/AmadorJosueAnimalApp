package com.example.amadorjosueanimalapp.model

data class Animal(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val gallery: List<String> = emptyList(),
    val facts: List<String> = emptyList(),
    val environment: String
)