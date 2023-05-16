package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextSubtitle(
    reminderSubtitle: String
) {
    Text(
        text = reminderSubtitle,
        color = Color.DarkGray,
        fontSize = 18.sp
    )
}