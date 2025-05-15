package com.rudraksha.catalift.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomButtons(
    isContinueEnabled: Boolean,
    onContinue: () -> Unit,
    onBack: () -> Unit
) {
    ContinueButton(isContinueEnabled, onContinue)
    Spacer(Modifier.height(12.dp))
    BackButton(onBack)
}

@Composable
fun ContinueButton(
    isContinueEnabled: Boolean,
    onContinue: () -> Unit,
) {
    Button(
        onClick = onContinue,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(28.dp),
        enabled = isContinueEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text("Continue")
    }
}

@Composable
fun BackButton(
    onBack: () -> Unit
) {
    OutlinedButton(
        onClick = onBack,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Text("Back", color = MaterialTheme.colorScheme.primary)
    }
}
