package com.diegonunez.thebestreminderapp.presentation.reminders.reminder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegonunez.thebestreminderapp.domain.repository.ReminderRepository

import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.presentation.core.ConstantsPresentation.Companion.NO_VALUE_PH
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RemindersViewModel @Inject constructor(
    private val repo: ReminderRepository
) : ViewModel() {
    var reminder by mutableStateOf(Reminder(0, NO_VALUE_PH, NO_VALUE_PH,NO_VALUE_PH,NO_VALUE_PH))
        private set
    var openDialog by mutableStateOf(false)

    val reminders = repo.getRemindersFromRoom()

    fun getReminder(id: Int) = viewModelScope.launch {
        reminder = repo.getReminderFromRoom(id)
    }

    fun addReminder(reminder: Reminder) = viewModelScope.launch {
        repo.addReminderToRoom(reminder)
    }

    fun updateReminder(reminder: Reminder) = viewModelScope.launch {
        repo.updateReminderInRoom(reminder)
    }

    fun deleteReminder(reminder: Reminder) = viewModelScope.launch {
        repo.deleteReminderFromRoom(reminder)
    }

    fun updateName(name: String) {
        reminder = reminder.copy(
            title = name //TODO: update
        )
    }

    fun updateDescription(description: String) {
        reminder = reminder.copy(
            description = description
        )
    }

    fun updateDate(date: String) {
        reminder = reminder.copy(
            date = date
        )
    }
    fun updateType(type: String) {
        reminder = reminder.copy(
            type = type
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}