package com.example.amadorjosueanimalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.amadorjosueanimalapp.ui.theme.AmadorJosueAnimalAppTheme
import com.example.amadorjosueanimalapp.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmadorJosueAnimalAppTheme {
                Navigation()
            }
        }
    }
}