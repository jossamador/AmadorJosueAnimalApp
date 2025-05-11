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
import com.example.amadorjosueanimalapp.model.Ambiente
import com.example.amadorjosueanimalapp.repository.AnimalRepository
import com.example.amadorjosueanimalapp.components.BottomNavBar
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
            items(ambientes) { ambiente ->
                AmbienteItem(ambiente) {
                    navController.navigate("ambienteDetalle/${ambiente.id}")
                }
            }
        }
    }
}

@Composable
fun AmbienteItem(ambiente: Ambiente, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(ambiente.image),
            contentDescription = ambiente.name,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(ambiente.name, style = MaterialTheme.typography.titleMedium)
    }
}