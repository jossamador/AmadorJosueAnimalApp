package com.example.amadorjosueanimalapp.model

data class Animal(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val gallery: List<String>,
    val facts: List<String>,
    val environment: String
)