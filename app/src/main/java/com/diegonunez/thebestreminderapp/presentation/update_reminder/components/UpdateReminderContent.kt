package com.diegonunez.thebestreminderapp.presentation.update_reminder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.SELECT_DATE
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.SELECT_TIME
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Buttons.UPDATE
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
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

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
    var pickedDateUpdate by remember {
        mutableStateOf(LocalDate.now())
    }
    var pickedTimeUpdate by remember {
        mutableStateOf(LocalTime.NOON)
    }

    val formattedDateUpdate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(pickedDateUpdate)
        }
    }
    val formattedTimeUpdate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm a")
                .format(pickedTimeUpdate)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()

    val dateUpdate ="$formattedDateUpdate $formattedTimeUpdate"
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

        Text(dateUpdate)

        LaunchedEffect(dateUpdate) {
            updateDate(dateUpdate)
        }


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                dateDialogState.show()
            }) {
                Text(text = SELECT_DATE)
            }
            Spacer(modifier = Modifier.width( 20.dp))
            Button(onClick = {
                timeDialogState.show()
            }) {
                Text(text = SELECT_TIME)
            }
        }
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
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Cancel")
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = SELECT_DATE
        ) {
            pickedDateUpdate = it
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
            title = SELECT_TIME
        ) {
            pickedTimeUpdate = it
        }
    }
}