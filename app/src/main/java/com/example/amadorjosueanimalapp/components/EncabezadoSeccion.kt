package com.example.amadorjosueanimalapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EncabezadoSeccion(
    titulo: String,
    subtitulo: String,
    tipo: String
) {
    val (colorInicio, colorFin, botonColor, textoColor, bordeColor) = when (tipo) {
        "animales" -> listOf(
            Color(0xFF4FC3F7), Color(0xFF1976D2),
            Color(0xFFBBDEFB), Color.Black, Color.Black
        )
        "ambientes" -> listOf(
            Color(0xFF81C784), Color(0xFF388E3C),
            Color(0xFFD0F0C0), Color.Black, Color.Black
        )
        else -> listOf(
            Color.Gray, Color.DarkGray,
            Color.LightGray, Color.Black, Color.Black
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(colorInicio, colorFin)
                )
            )
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.headlineMedium.copy(color = Color.White)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitulo,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { /* sin funcionalidad */ },
                    colors = ButtonDefaults.buttonColors(containerColor = botonColor),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .height(45.dp)
                        .defaultMinSize(minWidth = 130.dp)
                        .border(2.dp, bordeColor, RoundedCornerShape(50))
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar",
                        tint = textoColor
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Agregar", color = textoColor)
                }
            }
        }
    }
}