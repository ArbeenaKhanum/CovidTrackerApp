package com.example.covidtracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [StatesDataDetails::class, StatesName::class], version = 2, exportSchema = false)
abstract class StatesApiDatabase : RoomDatabase() {
    abstract val statesApiDao: StatesApiDao
    abstract val statesNameDao: StatesNameDao

    companion object {
        private var INSTANCE: StatesApiDatabase? = null

        fun getInstance(context: Context): StatesApiDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, StatesApiDatabase::class.java, "State_DB")
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}