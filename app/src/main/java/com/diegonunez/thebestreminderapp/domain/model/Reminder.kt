package com.diegonunez.thebestreminderapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegonunez.thebestreminderapp.data.core.Constants.Companion.REMINDER_TABLE

@Entity(tableName = REMINDER_TABLE)
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String
)