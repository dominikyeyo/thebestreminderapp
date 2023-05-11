package com.diegonunez.thebestreminderapp.data.repository

import com.diegonunez.thebestreminderapp.domain.repository.ReminderRepository
import com.diegonunez.thebestreminderapp.data.dao.ReminderDao
import com.diegonunez.thebestreminderapp.domain.model.Reminder

class ReminderRepositoryImpl(
    private val reminderDao: ReminderDao
) : ReminderRepository {
    override fun getRemindersFromRoom() = reminderDao.getReminders()

    override suspend fun getReminderFromRoom(id: Int) = reminderDao.getReminder(id)

    override suspend fun addReminderToRoom(reminder: Reminder) = reminderDao.addReminder(reminder)

    override suspend fun updateReminderInRoom(reminder: Reminder) = reminderDao.updateReminder(reminder)

    override suspend fun deleteReminderFromRoom(reminder: Reminder) = reminderDao.deleteReminder(reminder)
}