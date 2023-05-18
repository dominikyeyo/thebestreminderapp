package com.diegonunez.thebestreminderapp.presentation.reminders.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
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
import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Actions.ADD_REMINDER
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.ADD
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.DISMISS
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.SELECT_DATE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.SELECT_TIME
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.NO_VALUE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DATE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DATE_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DESCRIPTION
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_DESCRIPTION_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_NAME
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_NAME_PH
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_TYPE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Labels.REMINDER_TYPE_PH
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.job
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun AddReminderAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addReminder: (reminder: Reminder) -> Unit,
    setTimeNotification: () -> Unit
) {
    if (openDialog) {


        var name by remember { mutableStateOf(NO_VALUE) }
        var description by remember { mutableStateOf(NO_VALUE) }
        var type by remember { mutableStateOf(NO_VALUE) }

        var pickedDate by remember {
            mutableStateOf(LocalDate.now())
        }
        var pickedTime by remember {
            mutableStateOf(LocalTime.NOON)
        }
        val formattedDate by remember {
            derivedStateOf {
                DateTimeFormatter
                    .ofPattern("MMM dd yyyy")
                    .format(pickedDate)
            }
        }
        val formattedTime by remember {
            derivedStateOf {
                DateTimeFormatter
                    .ofPattern("hh:mm a")
                    .format(pickedTime)
            }
        }

        val dateDialogState = rememberMaterialDialogState()
        val timeDialogState = rememberMaterialDialogState()
        var date ="$formattedDate $formattedTime"

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
                        modifier = Modifier.height(20.dp)
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
                        readOnly = true,
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
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(onClick = {
                            dateDialogState.show()
                        }) {
                            Text(text = SELECT_DATE)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            timeDialogState.show()
                        }) {
                            Text(text = SELECT_TIME)
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
                MaterialDialog(
                    dialogState = dateDialogState,
                    buttons = {
                        positiveButton(text = "Ok")
                        negativeButton(text = "Cancel")
                    }
                ) {
                    datepicker(
                        initialDate = LocalDate.now(),
                        title = "Pick a date"
                    ) {
                        pickedDate = it
                    }
                }
                MaterialDialog(
                    dialogState = timeDialogState,
                    buttons = {
                        positiveButton(text = "Ok")
                        negativeButton(text = "Cancel")
                    }
                ) {
                    timepicker(
                        initialTime = LocalTime.NOON,
                        title = "Pick a time"
                    ) {
                        pickedTime = it
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val reminder = Reminder(0, name, description,date,type)
                        addReminder(reminder)
                        setTimeNotification()
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