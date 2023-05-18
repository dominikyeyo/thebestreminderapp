package com.diegonunez.thebestreminderapp.presentation.reminders.reminder

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.diegonunez.thebestreminderapp.presentation.reminders.components.AddReminderAlertDialog
import com.diegonunez.thebestreminderapp.presentation.reminders.components.AddReminderFloatingActionButton
import com.diegonunez.thebestreminderapp.presentation.reminders.components.RemindersContent
import com.diegonunez.thebestreminderapp.presentation.reminders.components.RemindersTopBar

@Composable
@ExperimentalMaterialApi
fun RemindersScreen(
    viewModel: RemindersViewModel = hiltViewModel(),
    navigateToUpdateReminderScreen: (reminderId: Int) -> Unit
) {
    val reminders by viewModel.reminders.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            RemindersTopBar()
        },
        content = { padding ->
            RemindersContent(
                padding = padding,
                reminders = reminders,
                deleteReminder = { reminder ->
                    viewModel.deleteReminder(reminder)
                },
                navigateToUpdateReminderScreen = navigateToUpdateReminderScreen
            )
            AddReminderAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addReminder = { reminder ->
                    viewModel.addReminder(reminder)
                },
                setReminderNotification = { reminder ->
                    viewModel.scheduleReminder(reminder)
                }
            )
        },
        floatingActionButton = {
            AddReminderFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}