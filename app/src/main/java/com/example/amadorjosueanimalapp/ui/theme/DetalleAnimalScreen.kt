package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

    LaunchedEffect(animalId) {
        coroutineScope.launch {
            animal = AnimalRepository.getAnimals().find { it.id == animalId }
        }
    }

    animal?.let { animalData ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = animalData.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = rememberAsyncImagePainter(animalData.image),
                contentDescription = animalData.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = animalData.description,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Galería",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow {
                items(animalData.gallery) { imageUrl ->
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(end = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Hechos Interesantes",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            animalData.facts.forEach { fact ->
                Text("• $fact", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}