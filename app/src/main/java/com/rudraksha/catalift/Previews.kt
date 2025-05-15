package com.rudraksha.catalift

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rudraksha.catalift.ui.theme.CataliftTheme
import android.content.res.Configuration.UI_MODE_NIGHT_YES

@Preview(showBackground = true, name = "Dream Profession Screen - Light")
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Dream Profession Screen - Dark")
@Composable
fun PreviewDreamProfessionScreen() {
    CataliftTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            DreamProfessionScreen(
                professions = listOf("Software Engineer", "Designer", "Data Scientist"),
                industries = listOf("Google", "Apple", "Microsoft"),
                onContinue = { _, _ -> },
                onBack = {}
            )
        }
    }
}

//@Preview(showBackground = true, name = "Interests Screen - Light")
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Interests Screen - Dark")
@Composable
fun PreviewInterestsScreen() {
    CataliftTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            InterestsScreen(
                rawTitles = listOf(
                    "Software", "Art", "Music", "Design",
                    "Fitness", "Gaming", "Cooking", "Travel"
                ),
                onContinue = {},
                onBack = {}
            )
        }
    }
}
