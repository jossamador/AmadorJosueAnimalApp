package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.amadorjosueanimalapp.components.BottomNavBar
import com.example.amadorjosueanimalapp.components.EncabezadoSeccion
import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import kotlinx.coroutines.launch

@Composable
fun ListaAnimalesScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var animales by remember { mutableStateOf<List<Animal>>(emptyList()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            animales = AnimalRepository.getAnimals()
        }
    }

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                EncabezadoSeccion(
                    titulo = "Animales",
                    subtitulo = "Lista de especies disponibles",
                    tipo = "animales"
                )
            }
            items(animales) { animal ->
                AnimalCard(animal) {
                    navController.navigate("animalDetalle/${animal.id}")
                }
            }
        }
    }
}

@Composable
fun AnimalCard(animal: Animal, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF42A5F5), CircleShape) // Azul
                    .background(Color.White)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(animal.image),
                    contentDescription = animal.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(animal.name, style = MaterialTheme.typography.titleMedium)
                Text(animal.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}