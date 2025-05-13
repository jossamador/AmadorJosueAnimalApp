package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.model.Ambiente
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
            val encontrado = animales.find { it.id == animalId }
            animal = encontrado

            encontrado?.let {
                val ambientes = AnimalRepository.getAmbientes()
                ambiente = ambientes.find { it.id == encontrado.environment }
            }
        }
    }

    if (animal != null) {
        DetalleAnimalContent(animal!!, ambiente)
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun DetalleAnimalContent(animal: Animal, ambiente: Ambiente?) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Hero Image
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
                        brush = Brush.verticalGradient(
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

        // Descripción
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
        Text(
            "Galería",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
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
        Text(
            "Hechos Interesantes",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
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

        Spacer(modifier = Modifier.height(16.dp))

        // Ambiente
        ambiente?.let {
            Text("Ambiente", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(horizontal = 16.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(it.image),
                    contentDescription = it.name,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(it.name, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}