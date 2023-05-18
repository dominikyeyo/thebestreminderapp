package com.diegonunez.thebestreminderapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.diegonunez.thebestreminderapp.data.core.Constants.Companion.REMINDER_TABLE
import com.diegonunez.thebestreminderapp.data.dao.ReminderDao
import com.diegonunez.thebestreminderapp.data.network.ReminderDb
import com.diegonunez.thebestreminderapp.data.repository.ReminderRepositoryImpl
import com.diegonunez.thebestreminderapp.domain.repository.ReminderRepository
import com.diegonunez.thebestreminderapp.TheBestReminderApp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): TheBestReminderApp {
        return app as TheBestReminderApp
    }

    @Provides
    fun provideReminderDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        ReminderDb::class.java,
        REMINDER_TABLE
    ).build()



    @Provides
    fun provideReminderDao(
        reminderDb: ReminderDb
    ) = reminderDb.reminderDao


    @Provides
    fun provideReminderRepository(
        reminderDao: ReminderDao
    ): ReminderRepository = ReminderRepositoryImpl(
        reminderDao = reminderDao
    )


}