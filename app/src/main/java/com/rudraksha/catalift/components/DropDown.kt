package com.rudraksha.catalift.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DropdownRow(
    professions: List<String>,
    selectedProfession: String,
    onProfessionSelected: (String) -> Unit,
    industries: List<String>,
    selectedIndustry: String,
    onIndustrySelected: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "I want to be a...",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .height(36.dp)
                .align(Alignment.Bottom)
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

        Text(
            text = "at",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .height(36.dp)
                .align(Alignment.Bottom)
        )

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownSelector(
    options: List<String>,
    selectedOption: String,
    onOptionSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        /*OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.clickable { expanded = true } // handle dropdown expansion here
                )
            },
            shape = RoundedCornerShape(percent = 50),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                disabledBorderColor = MaterialTheme.colorScheme.secondary,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                disabledTextColor = MaterialTheme.colorScheme.onSurface
            ),
            textStyle = MaterialTheme.typography.labelSmall
        )*/
        val interactionSource = remember { MutableInteractionSource() }

        BasicTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            interactionSource = interactionSource,
            textStyle = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onSurface),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(percent = 50)
                )
                .clip(shape = RoundedCornerShape(percent = 50))
                .background(Color.Transparent),
            decorationBox = { innerTextField ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = selectedOption,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    ), // adjust here
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.clickable {
                                scope.launch {
                                    expanded = true
                                }
                            }
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.secondary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                        disabledBorderColor = MaterialTheme.colorScheme.secondary,
                        focusedTextColor = MaterialTheme.colorScheme.onSurface,
                        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                        disabledTextColor = MaterialTheme.colorScheme.onSurface
                    ),
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        scope.launch {
                            onOptionSelect(option)
                            expanded = false
                        }
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