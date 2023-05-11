package com.diegonunez.thebestreminderapp.presentation.update_reminder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegonunez.thebestreminderapp.core.Constants.Companion.REMINDER_NAME
import com.diegonunez.thebestreminderapp.core.Constants.Companion.UPDATE
import com.diegonunez.thebestreminderapp.core.Constants.Companion.DESCRIPTION
import com.diegonunez.thebestreminderapp.domain.model.Reminder

@Composable
fun UpdateReminderContent(
    padding: PaddingValues,
    reminder: Reminder,
    updateName: (title: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateReminder: (reminder: Reminder) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = reminder.title,
            onValueChange = { title ->
                updateName(title)
            },
            placeholder = {
                Text(
                    text = REMINDER_NAME
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = reminder.description,
            onValueChange = { description ->
                updateDescription(description)
            },
            placeholder = {
                Text(
                    text = DESCRIPTION
                )
            }
        )
        Button(
            onClick = {
                updateReminder(reminder)
                navigateBack()
            }
        ) {
            Text(
                text = UPDATE
            )
        }
    }
}