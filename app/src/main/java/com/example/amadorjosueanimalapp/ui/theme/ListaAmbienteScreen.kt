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
import com.example.amadorjosueanimalapp.model.Ambiente
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import kotlinx.coroutines.launch

@Composable
fun ListaAmbienteScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var ambientes by remember { mutableStateOf<List<Ambiente>>(emptyList()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            ambientes = AnimalRepository.getAmbientes()
        }
    }

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                EncabezadoSeccion(
                    titulo = "Ambientes",
                    subtitulo = "Explora los hábitats de los animales",
                    tipo = "ambientes"
                )
            }
            items(ambientes) { ambiente ->
                AmbienteCard(ambiente) {
                    navController.navigate("ambienteDetalle/${ambiente.id}")
                }
            }
        }
    }
}

@Composable
fun AmbienteCard(ambiente: Ambiente, onClick: () -> Unit) {
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
                    .border(2.dp, Color(0xFF4CAF50), CircleShape) // Verde vivo
                    .background(Color.White)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(ambiente.image),
                    contentDescription = ambiente.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(ambiente.name, style = MaterialTheme.typography.titleMedium)
                Text(ambiente.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}