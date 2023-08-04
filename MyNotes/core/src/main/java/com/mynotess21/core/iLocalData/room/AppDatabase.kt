package com.mynotess21.core.iLocalData.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mynotess21.core.iLocalData.room.dao.NoteDao
import com.mynotess21.core.models.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun noteDao():NoteDao
}