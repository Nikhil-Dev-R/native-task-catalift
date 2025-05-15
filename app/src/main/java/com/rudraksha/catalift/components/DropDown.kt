package com.rudraksha.catalift.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropdownRow(
    professions: List<String>,
    selectedProfession: String,
    onProfessionSelected: (String) -> Unit,
    industries: List<String>,
    selectedIndustry: String,
    onIndustrySelected: (String) -> Unit
) {
    /*LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        userScrollEnabled = false // Optional: disables scrolling
    ) {
        // Labels row
        item(span = { GridItemSpan(2) }) {
            Box(
                contentAlignment = Alignment.CenterEnd,
            ) {
                Text(
                    text = "Profession",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray,
                )
            }
        }
        item(span = { GridItemSpan(2) }) {
            Text(
                text = "Company/Industry",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }

        // Selector line: "I want to be a" | Profession dropdown | "at" | Industry dropdown
        item(span = { GridItemSpan(1) }) {
            Text(
                text = "I want to be a...",
                style = MaterialTheme.typography.bodySmall
            )
        }
        item(span = { GridItemSpan(1) }) {
            DropdownSelector(
                options = professions,
                selectedOption = selectedProfession,
                onOptionSelect = onProfessionSelected,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item(span = { GridItemSpan(1) }) {
            Text(
                text = "at",
                style = MaterialTheme.typography.bodySmall
            )
        }
        item(span = { GridItemSpan(1) }) {
            DropdownSelector(
                options = industries,
                selectedOption = selectedIndustry,
                onOptionSelect = onIndustrySelected,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }*/

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "I want to be a...",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Profession",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            DropdownSelector(
                options = professions,
                selectedOption = selectedProfession,
                onOptionSelect = onProfessionSelected,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text("at", modifier = Modifier.align(Alignment.CenterVertically))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Company/Industry",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            DropdownSelector(
                options = industries,
                selectedOption = selectedIndustry,
                onOptionSelect = onIndustrySelected,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun DropdownSelector(
    options: List<String>,
    selectedOption: String,
    onOptionSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.secondary
            ),
            textStyle = MaterialTheme.typography.labelSmall
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelect(option)
                        expanded = false
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun DD() {
    DropdownRow(
        professions = listOf("Software Engineer", "Designer", "Data Scientist"),
        selectedProfession = "Software Engineer",
        onProfessionSelected = {},
        industries = listOf("Google", "Apple", "Microsoft"),
        selectedIndustry = "Google",
        onIndustrySelected = {}
    )
}