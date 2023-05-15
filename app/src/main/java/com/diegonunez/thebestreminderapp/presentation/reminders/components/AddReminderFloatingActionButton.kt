package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.ADD_REMINDER

@Composable
fun AddReminderFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_REMINDER
        )
    }
}