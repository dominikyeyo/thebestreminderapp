package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDERS_SCREEN


@Composable
fun RemindersTopBar() {
    TopAppBar (
        title = {
            Text(
                text = REMINDERS_SCREEN
            )
        }
    )
}