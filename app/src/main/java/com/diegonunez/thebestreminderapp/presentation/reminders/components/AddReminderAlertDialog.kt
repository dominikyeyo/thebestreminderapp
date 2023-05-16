package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.ADD
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.DISMISS
import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.ADD_REMINDER
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.NO_VALUE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_DATE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_DATE_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_DESCRIPTION
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_DESCRIPTION_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_NAME
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_NAME_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_TYPE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.REMINDER_TYPE_PH
import kotlinx.coroutines.job

@Composable
fun AddReminderAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addReminder: (reminder: Reminder) -> Unit
) {
    if (openDialog) {


        var name by remember { mutableStateOf(NO_VALUE) }
        var description by remember { mutableStateOf(NO_VALUE) }
        var date by remember { mutableStateOf(NO_VALUE) }
        var type by remember { mutableStateOf(NO_VALUE) }

        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = ADD_REMINDER,
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column {

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = REMINDER_NAME) },
                        placeholder = {
                            Text(
                                text = REMINDER_NAME_PH
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )

                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text(text = REMINDER_DESCRIPTION) },
                        placeholder = {
                            Text(
                                text = REMINDER_DESCRIPTION_PH
                            )
                        }
                    )

                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    TextField(
                        value = date,
                        onValueChange = { date = it },
                        label = { Text(text = REMINDER_DATE) },
                        placeholder = {
                            Text(
                                text = REMINDER_DATE_PH
                            )
                        }
                    )

                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    TextField(
                        value = type,
                        onValueChange = { type = it },
                        label = { Text(text = REMINDER_TYPE) },
                        placeholder = {
                            Text(
                                text = REMINDER_TYPE_PH
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val reminder = Reminder(0, name, description,date,type)
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