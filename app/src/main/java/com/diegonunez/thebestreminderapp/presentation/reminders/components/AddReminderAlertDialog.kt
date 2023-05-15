package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.ADD
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.DISMISS
import com.diegonunez.thebestreminderapp.domain.model.Reminder

import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.ADD_REMINDER

@Composable
fun AddReminderAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addReminder: (reminder: Reminder) -> Unit
) {
    if (openDialog) {

        /*
        var name by remember { mutableStateOf(NO_VALUE) }
        var description by remember { mutableStateOf(NO_VALUE) }
        */

        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = ADD_REMINDER
                )
            },
            text = {
                Column {
                    /*
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = REMINDER_TITLE
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    */

                    Text("REMINDER")


                    /*
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    */
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    /*
                    TextField(
                        value = description,
                        placeholder = {
                            Text(
                                text = DESCRIPTION
                            )
                        }
                    )
                    */
                    Text("DESCRIPTION")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val reminder = Reminder(0, "Reminder", "description")
                        addReminder(reminder)
                    }
                ) {
                    Text(
                        text = ADD
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = DISMISS
                    )
                }
            }
        )
    }
}