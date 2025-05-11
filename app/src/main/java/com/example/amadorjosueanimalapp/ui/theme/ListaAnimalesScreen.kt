package com.example.amadorjosueanimalapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.amadorjosueanimalapp.model.Animal
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import com.example.amadorjosueanimalapp.components.BottomNavBar
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
            items(animales) { animal ->
                AnimalItem(animal) {
                    navController.navigate("animalDetalle/${animal.id}")
                }
            }
        }
    }
}

@Composable
fun AnimalItem(animal: Animal, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(animal.image),
            contentDescription = animal.name,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(animal.name, style = MaterialTheme.typography.titleMedium)
    }
}