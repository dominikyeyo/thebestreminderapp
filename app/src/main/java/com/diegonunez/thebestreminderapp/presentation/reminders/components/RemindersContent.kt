package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.domain.repository.Reminders

@Composable
@ExperimentalMaterialApi
fun RemindersContent(
    padding: PaddingValues,
    reminders: Reminders,
    deleteReminder: (reminder: Reminder) -> Unit,
    navigateToUpdateReminderScreen: (reminderId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = reminders
        ) { reminder ->
            ReminderCard(
                reminder = reminder,
                deleteReminder = {
                    deleteReminder(reminder)
                },
                navigateToUpdateReminderScreen = navigateToUpdateReminderScreen
            )
        }
    }
}