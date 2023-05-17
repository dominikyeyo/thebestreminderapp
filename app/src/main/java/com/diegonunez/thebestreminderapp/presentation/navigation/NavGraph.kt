package com.diegonunez.thebestreminderapp.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Arguments.REMINDER_ID


import com.diegonunez.thebestreminderapp.presentation.navigation.Screen.UpdateReminderScreen
import com.diegonunez.thebestreminderapp.presentation.reminders.reminder.RemindersScreen
import com.diegonunez.thebestreminderapp.presentation.update_reminder.UpdateReminderScreen


@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.RemindersScreen.route
    ) {
        composable(
            route = Screen.RemindersScreen.route
        ) {
            RemindersScreen(
                navigateToUpdateReminderScreen = { reminderId ->
                    navController.navigate(
                        route = "${UpdateReminderScreen.route}/${reminderId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateReminderScreen.route}/{$REMINDER_ID}",
            arguments = listOf(
                navArgument(REMINDER_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val reminderId = backStackEntry.arguments?.getInt(REMINDER_ID) ?: 0
            UpdateReminderScreen(
                reminderId = reminderId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}