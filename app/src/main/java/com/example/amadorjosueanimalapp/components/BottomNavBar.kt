package com.example.amadorjosueanimalapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Pets, contentDescription = "Animales") },
            label = { Text("Animales") },
            selected = currentDestination == "animales",
            onClick = {
                if (currentDestination != "animales") {
                    navController.navigate("animales") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Public, contentDescription = "Ambientes") },
            label = { Text("Ambientes") },
            selected = currentDestination == "ambientes",
            onClick = {
                if (currentDestination != "ambientes") {
                    navController.navigate("ambientes") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )
    }
}