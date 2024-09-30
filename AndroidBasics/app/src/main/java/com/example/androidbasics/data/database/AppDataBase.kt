package com.example.androidbasics.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidbasics.data.dao.PersonagemDao
import com.example.androidbasics.data.entities.PersonagemEntity

@Database(entities = [PersonagemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personagemDao(): PersonagemDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "personagem_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
