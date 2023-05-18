package com.diegonunez.thebestreminderapp.presentation.update_reminder

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.diegonunez.thebestreminderapp.presentation.reminders.reminder.RemindersViewModel
import com.diegonunez.thebestreminderapp.presentation.update_reminder.components.UpdateReminderContent
import com.diegonunez.thebestreminderapp.presentation.update_reminder.components.UpdateReminderTopBar

@Composable
fun UpdateReminderScreen(
    viewModel: RemindersViewModel = hiltViewModel(),
    reminderId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getReminder(reminderId)
    }
    Scaffold(
        topBar = {
            UpdateReminderTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateReminderContent(
                padding = padding,
                reminder = viewModel.reminder,
                updateName = { title ->
                    viewModel.updateName(title)
                },
                updateDescription = { description ->
                    viewModel.updateDescription(description)
                },
                updateDate = { date ->
                    viewModel.updateDate(date)
                },
                updateType = { type ->
                    viewModel.updateType(type)
                },
                updateReminder = { reminder ->
                    viewModel.updateReminder(reminder)
                },
                updateReminderNotification = { reminder ->
                    viewModel.scheduleReminder(reminder)
                },
                navigateBack = navigateBack
            )

        }
    )
}