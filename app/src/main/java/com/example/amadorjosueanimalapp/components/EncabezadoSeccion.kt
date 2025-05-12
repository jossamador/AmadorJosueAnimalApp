package com.example.amadorjosueanimalapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EncabezadoSeccion(titulo: String, subtitulo: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFF2196F3), Color(0xFF64B5F6))
                )
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.headlineMedium.copy(color = Color.White)
            )
            Text(
                text = subtitulo,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
            )
        }

        OutlinedButton(
            onClick = { /* Acción no funcional */ },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White.copy(alpha = 0.4f),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(20.dp),
            border = ButtonDefaults.outlinedButtonBorder,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .height(40.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Agregar")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Agregar")
        }
    }
}