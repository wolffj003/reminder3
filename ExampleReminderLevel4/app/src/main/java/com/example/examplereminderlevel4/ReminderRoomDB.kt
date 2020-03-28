package com.example.examplereminderlevel4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Reminder::class], version = 1, exportSchema = false)
abstract class ReminderRoomDB : RoomDatabase() {

    abstract fun reminderDao(): ReminderDao

    companion object {
        private const val DATABASE_NAME = "REMINDER_DATABASE"

        @Volatile
        private var reminderRoomDBInstance: ReminderRoomDB? = null

        fun getDatabase(context: Context): ReminderRoomDB? {
            if (reminderRoomDBInstance == null) {
                synchronized(ReminderRoomDB::class.java) {
                    if (reminderRoomDBInstance == null) {
                        reminderRoomDBInstance = Room.databaseBuilder(
                            context.applicationContext,
                            ReminderRoomDB::class.java, DATABASE_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return reminderRoomDBInstance
        }
    }
}