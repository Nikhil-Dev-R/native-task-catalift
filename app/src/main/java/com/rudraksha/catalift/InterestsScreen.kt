package com.rudraksha.catalift

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rudraksha.catalift.components.BottomButtons
import com.rudraksha.catalift.components.ChipsFlow
import com.rudraksha.catalift.components.HeaderSection
import com.rudraksha.catalift.components.SearchBar
import com.rudraksha.catalift.components.TopProgressBar

data class Interest(val id: Int, val title: String)

@Composable
fun InterestsScreen(
    rawTitles: List<String>,
    onContinue: (List<Interest>) -> Unit,
    onBack: () -> Unit
) {
    // wrap strings into unique-idded items
    val allInterests = remember(rawTitles) {
        rawTitles.mapIndexed { idx, title -> Interest(idx, title) }
    }

    var query by remember { mutableStateOf("") }
    var selectedIds by remember { mutableStateOf(setOf<Int>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .navigationBarsPadding()
    ) {
        TopProgressBar(progress = 0.3f)
        Spacer(Modifier.height(24.dp))
        HeaderSection(
            title = "Your Interests"
        )
        Spacer(Modifier.height(24.dp))
        SearchBar(query = query, onQueryChange = { query = it })
        Spacer(Modifier.height(24.dp))
        val filtered = if (query.isBlank()) allInterests
        else allInterests.filter { it.title.contains(query, ignoreCase = true) }
        ChipsFlow(
            interests = filtered,
            selectedIds = selectedIds,
            onChipToggle = { id ->
                selectedIds = if (selectedIds.contains(id))
                    selectedIds - id else selectedIds + id
            }
        )
        Spacer(Modifier.weight(1f))
        BottomButtons(
            isContinueEnabled = selectedIds.isNotEmpty(),
            onContinue = { onContinue(allInterests.filter { it.id in selectedIds }) },
            onBack = onBack
        )
    }
}
