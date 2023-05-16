package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegonunez.thebestreminderapp.domain.model.Reminder

@Composable
@ExperimentalMaterialApi
fun ReminderCard(
    reminder: Reminder,
    deleteReminder: () -> Unit,
    navigateToUpdateReminderScreen: (reminderId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateReminderScreen(reminder.id)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TextName(
                    reminderName = reminder.title
                )
                TextSubtitle(
                    reminderSubtitle = "Date: " + reminder.date
                )
                TextSubtitle(
                    reminderSubtitle = "Type: " + reminder.type
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteReminder = deleteReminder
            )
        }
    }
}