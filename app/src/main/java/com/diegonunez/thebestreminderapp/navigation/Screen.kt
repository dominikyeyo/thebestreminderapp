package com.diegonunez.thebestreminderapp.navigation

import com.diegonunez.thebestreminderapp.core.Constants.Companion.REMINDERS_SCREEN
import com.diegonunez.thebestreminderapp.core.Constants.Companion.UPDATE_REMINDER_SCREEN

sealed class Screen(val route: String) {
    object RemindersScreen: Screen(REMINDERS_SCREEN)
    object UpdateReminderScreen: Screen(UPDATE_REMINDER_SCREEN)
}