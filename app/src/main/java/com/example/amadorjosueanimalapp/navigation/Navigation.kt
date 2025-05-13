package com.example.amadorjosueanimalapp.navigation

import com.example.amadorjosueanimalapp.ui.theme.ListaAmbienteScreen
import com.example.amadorjosueanimalapp.ui.theme.DetalleAmbienteScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.amadorjosueanimalapp.ui.theme.*

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "animales") {
        composable("animales") { ListaAnimalesScreen(navController) }
        composable("ambientes") { ListaAmbienteScreen(navController) }
        composable("animalDetalle/{animalId}") { backStackEntry ->
            DetalleAnimalScreen(
                navController,
                animalId = backStackEntry.arguments?.getString("animalId") ?: ""
            )
        }
        composable("ambienteDetalle/{ambienteId}") { backStackEntry ->
            val ambienteId = backStackEntry.arguments?.getString("ambienteId") ?: ""
            DetalleAmbienteScreen(
                navController,
                ambienteId)
        }
    }
}