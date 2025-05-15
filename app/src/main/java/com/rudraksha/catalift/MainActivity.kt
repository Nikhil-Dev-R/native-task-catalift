package com.rudraksha.catalift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rudraksha.catalift.ui.theme.CataliftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CataliftTheme {
                DreamProfessionScreen(
                    professions = listOf("Software Engineer", "Designer", "Data Scientist"),
                    industries = listOf("Google", "Apple", "Microsoft"),
                    onContinue = { _, _ -> },
                    onBack = {}
                )
            }
        }
    }
}
