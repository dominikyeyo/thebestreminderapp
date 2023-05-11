package com.diegonunez.thebestreminderapp.presentation.update_reminder.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.diegonunez.thebestreminderapp.core.Constants.Companion.UPDATE_REMINDER_SCREEN

@Composable
fun UpdateReminderTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = UPDATE_REMINDER_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}