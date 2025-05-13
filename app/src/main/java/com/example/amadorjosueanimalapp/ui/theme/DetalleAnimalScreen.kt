package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.amadorjosueanimalapp.model.Ambiente
import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import kotlinx.coroutines.launch

@Composable
fun DetalleAnimalScreen(navController: NavController, animalId: String) {
    val coroutineScope = rememberCoroutineScope()
    var animal by remember { mutableStateOf<Animal?>(null) }
    var ambiente by remember { mutableStateOf<Ambiente?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val animales = AnimalRepository.getAnimals()
            animal = animales.find { it.id == animalId }

            // cargar ambiente relacionado
            val ambientes = AnimalRepository.getAmbientes()
            ambiente = ambientes.find { it.id == animal?.environment }
        }
    }

    if (animal != null) {
        DetalleAnimalContent(animal = animal!!, ambiente = ambiente)
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun DetalleAnimalContent(animal: Animal, ambiente: Ambiente?) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Encabezado visual
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(animal.image),
                contentDescription = animal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f))
                        )
                    )
            )
            Text(
                text = animal.name,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Tarjeta de descripción
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Text(
                text = animal.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Galería
        Text("Galería", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(horizontal = 16.dp))
        LazyRow(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
            items(animal.gallery) { imageUrl ->
                Card(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Hechos interesantes
        Text("Hechos Interesantes", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(horizontal = 16.dp))
        Column(modifier = Modifier.padding(16.dp)) {
            animal.facts.forEach { fact ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = fact)
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

        // Ambiente (si no es nulo)
        ambiente?.let {
            Spacer(modifier = Modifier.height(16.dp))
            // Sección del Ambiente sin descripción
            Text("Ambiente", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(horizontal = 16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column {
                    Image(
                        painter = rememberAsyncImagePainter(ambiente!!.image),
                        contentDescription = ambiente!!.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = ambiente!!.name,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                    )
                }
            }
        }
    }
}