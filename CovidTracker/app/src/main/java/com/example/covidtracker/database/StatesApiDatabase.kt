package com.example.covidtracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StatesDataDetails::class], version = 1, exportSchema = false)
abstract class StatesApiDatabase : RoomDatabase() {
    abstract val statesApiDao: StatesApiDao

    companion object {
        private var INSTANCE: StatesApiDatabase? = null

        fun getInstance(context: Context): StatesApiDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, StatesApiDatabase::class.java, "State_DB")
                            .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}