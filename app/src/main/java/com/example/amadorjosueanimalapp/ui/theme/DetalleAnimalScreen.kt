package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import kotlinx.coroutines.launch

@Composable
fun DetalleAnimalScreen(navController: NavController, animalId: String) {
    val coroutineScope = rememberCoroutineScope()
    var animal by remember { mutableStateOf<Animal?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val animales = AnimalRepository.getAnimals()
            animal = animales.find { it.id == animalId }
        }
    }

    animal?.let {
        DetalleAnimalContent(it)
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun DetalleAnimalContent(animal: Animal) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(animal.name, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = rememberAsyncImagePainter(animal.image),
            contentDescription = animal.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(animal.description)

        if (animal.gallery.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Galería", style = MaterialTheme.typography.titleMedium)
            LazyRow {
                items(animal.gallery) { imageUrl ->
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = "Imagen de galería",
                        modifier = Modifier
                            .padding(8.dp)
                            .size(120.dp)
                    )
                }
            }
        }

        if (animal.facts.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Hechos Interesantes", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            animal.facts.forEach { fact ->
                Text("• $fact", modifier = Modifier.padding(bottom = 4.dp))
            }
        }
    }
}