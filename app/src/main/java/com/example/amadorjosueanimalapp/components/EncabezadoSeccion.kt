package com.example.amadorjosueanimalapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public

@Composable
fun EncabezadoSeccion(
    titulo: String,
    subtitulo: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        // Fondo azul
        Surface(
            color = Color(0xFF1E88E5),
            modifier = Modifier.fillMaxSize()
        ) {}

        // Contenido del encabezado
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.White)
                )
                Text(
                    text = subtitulo,
                    fontSize = 14.sp,
                    color = Color(0xFFBBDEFB)
                )
            }

            OutlinedButton(
                onClick = { /* No funcional */ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF90CAF9),
                    contentColor = Color.Black
                ),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Icon(
                    imageVector = Icons.Default.Public,
                    contentDescription = "Icono agregar"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Agregar")
            }
        }
    }
}