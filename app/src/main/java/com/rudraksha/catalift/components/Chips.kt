package com.rudraksha.catalift.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rudraksha.catalift.Interest
import kotlin.collections.forEach

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipsFlow(
    interests: List<Interest>,
    selectedIds: Set<Int>,
    onChipToggle: (Int) -> Unit
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        interests.forEach { interest ->
            InterestChip(
                title = interest.title,
                isSelected = selectedIds.contains(interest.id),
                onClick = { onChipToggle(interest.id) }
            )
        }
    }
}

@Composable
fun InterestChip(title: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(50),
        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
        border = if (!isSelected) {
            BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        } else null,
        modifier = Modifier
            .height(40.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(Color.Transparent)
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = if (isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.primary
            )
        }
    }
}