package com.diegonunez.thebestreminderapp.presentation.navigation

import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Screens.REMINDERS_SCREEN
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Screens.UPDATE_REMINDER_SCREEN

sealed class Screen(val route: String) {
    object RemindersScreen: Screen(REMINDERS_SCREEN)
    object UpdateReminderScreen: Screen(UPDATE_REMINDER_SCREEN)
}