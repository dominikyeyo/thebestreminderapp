package com.diegonunez.thebestreminderapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.diegonunez.thebestreminderapp.core.Constants.Companion.REMINDER_TABLE
import com.diegonunez.thebestreminderapp.domain.model.Reminder
import com.diegonunez.thebestreminderapp.domain.repository.Reminders
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    @Query("SELECT * FROM $REMINDER_TABLE ORDER BY id ASC")
    fun getReminders(): Flow<Reminders>

    @Query("SELECT * FROM $REMINDER_TABLE WHERE id = :id")
    suspend fun getReminder(id: Int): Reminder

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)
}