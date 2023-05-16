package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextName(
    reminderName: String
) {
    Text(
        text = reminderName,
        color = Color.DarkGray,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
}