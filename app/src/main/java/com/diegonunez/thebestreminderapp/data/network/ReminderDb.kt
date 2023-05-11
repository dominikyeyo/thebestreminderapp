package com.diegonunez.thebestreminderapp.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diegonunez.thebestreminderapp.data.dao.ReminderDao
import com.diegonunez.thebestreminderapp.domain.model.Reminder

@Database(
    entities = [Reminder::class],
    version = 1,
    exportSchema = false
)
abstract class ReminderDb : RoomDatabase() {
    abstract val reminderDao: ReminderDao
}