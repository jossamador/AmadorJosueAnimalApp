package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.model.Ambiente
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import kotlinx.coroutines.launch

@Composable
fun DetalleAmbienteScreen(navController: NavController, ambienteId: String) {
    val coroutineScope = rememberCoroutineScope()
    var ambiente by remember { mutableStateOf<Ambiente?>(null) }
    var animales by remember { mutableStateOf<List<Animal>>(emptyList()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val ambientes = AnimalRepository.getAmbientes()
            ambiente = ambientes.find { it.id == ambienteId }
            animales = AnimalRepository.getAnimals().filter { it.environment == ambienteId }
        }
    }

    ambiente?.let {
        DetalleAmbienteContent(it, animales)
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun DetalleAmbienteContent(ambiente: Ambiente, animales: List<Animal>) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(ambiente.name, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = rememberAsyncImagePainter(ambiente.image),
            contentDescription = ambiente.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(ambiente.description)

        Spacer(modifier = Modifier.height(16.dp))
        Text("Animales en este ambiente", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(animales) { animal ->
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(animal.image),
                        contentDescription = animal.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(animal.name, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}