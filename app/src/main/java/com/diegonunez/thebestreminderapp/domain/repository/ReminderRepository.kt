package com.diegonunez.thebestreminderapp.domain.repository

import com.diegonunez.thebestreminderapp.domain.model.Reminder
import kotlinx.coroutines.flow.Flow

typealias Reminders = List<Reminder>

interface ReminderRepository {
    fun getRemindersFromRoom(): Flow<Reminders>

    suspend fun getReminderFromRoom(id: Int): Reminder

    suspend fun addReminderToRoom(reminder: Reminder)

    suspend fun updateReminderInRoom(reminder: Reminder)

    suspend fun deleteReminderFromRoom(reminder: Reminder)
}