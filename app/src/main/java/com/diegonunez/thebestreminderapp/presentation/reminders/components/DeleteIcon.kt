package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Actions.DELETE_REMINDER


@Composable
fun DeleteIcon(
    deleteReminder: () -> Unit
) {
    IconButton(
        onClick = deleteReminder
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_REMINDER,
        )
    }
}