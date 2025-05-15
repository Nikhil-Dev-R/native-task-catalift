package com.rudraksha.catalift

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rudraksha.catalift.components.BottomButtons
import com.rudraksha.catalift.components.DropdownRow
import com.rudraksha.catalift.components.HeaderSection
import com.rudraksha.catalift.components.TopProgressBar

@Composable
fun DreamProfessionScreen(
    professions: List<String>,
    industries: List<String>,
    onContinue: (selectedProfession: String, selectedIndustry: String) -> Unit,
    onBack: () -> Unit
) {
    var selectedProfession by remember { mutableStateOf("") }
    var selectedIndustry by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopProgressBar(progress = 0.6f)
        Spacer(Modifier.height(24.dp))
        Illustration()
        Spacer(Modifier.height(24.dp))
        HeaderSection(
            title = "Your Dream Profession"
        )
        Spacer(Modifier.height(24.dp))
        DropdownRow(
            professions = professions,
            selectedProfession = selectedProfession,
            onProfessionSelected = { selectedProfession = it },
            industries = industries,
            selectedIndustry = selectedIndustry,
            onIndustrySelected = { selectedIndustry = it }
        )
        Spacer(Modifier.weight(1f))
        BottomButtons(
            isContinueEnabled = selectedProfession.isNotEmpty() && selectedIndustry.isNotEmpty(),
            onContinue = { onContinue(selectedProfession, selectedIndustry) },
            onBack = onBack
        )
    }
}

@Composable
fun Illustration() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("[Illustration]", color = Color.DarkGray)
    }
}
