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
import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.UPDATE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DATE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DATE_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DESCRIPTION
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DESCRIPTION_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_NAME
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_NAME_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_TYPE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_TYPE_PH

@Composable
fun UpdateReminderContent(
    padding: PaddingValues,
    reminder: Reminder,
    updateName: (title: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateDate: (date: String) -> Unit,
    updateType: (type: String) -> Unit,
    updateReminder: (reminder: Reminder) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        TextField(
            value = reminder.title,
            onValueChange = { title ->
                updateName(title)
            },
            label = { Text(text = REMINDER_NAME) },
            placeholder = {
                Text(
                    text = REMINDER_NAME_PH
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
            label = { Text(text = REMINDER_DESCRIPTION) },
            placeholder = {
                Text(
                    text = REMINDER_DESCRIPTION_PH
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = reminder.date,
            onValueChange = { date ->
                updateDate(date)
            },
            label = { Text(text = REMINDER_DATE) },
            placeholder = {
                Text(
                    text = REMINDER_DATE_PH
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = reminder.type,
            onValueChange = { type ->
                updateType(type)
            },
            label = { Text(text = REMINDER_TYPE) },
            placeholder = {
                Text(
                    text = REMINDER_TYPE_PH
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
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