package com.rudraksha.catalift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rudraksha.catalift.ui.theme.CataliftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CataliftTheme {
                val navController = rememberNavController()
                NavigationManager(navController)
            }
        }
    }
}

@Composable
fun NavigationManager(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "interests") {
        composable("interests") {
            InterestsScreen(
                rawTitles = listOf(
                    "Software", "Art", "Music", "Design",
                    "Fitness", "Gaming", "Cooking", "Travel"
                ),
                onContinue = {
                    navController.navigate("dreamProfession")
                },
                onBack = {}
            )
        }

        composable("dreamProfession") {
            DreamProfessionScreen(
                professions = listOf("Software Engineer", "Designer", "Data Scientist"),
                industries = listOf("Google", "Apple", "Microsoft"),
                onContinue = { _, _ -> },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}