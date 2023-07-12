package com.mynotess21.mynotes.di

import android.content.Context
import androidx.room.Room
import com.mynotess21.core.iLocalData.room.AppDatabase
import com.mynotess21.core.iLocalData.room.dao.NoteDao
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule = module {
    single { providesDatabase(get()) }
    single { providesNoteDao(get()) }

}

fun providesDatabase(context: Context): AppDatabase = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "mynotesdatabase"
)
    .fallbackToDestructiveMigration()
    .build()

fun providesNoteDao(db: AppDatabase): NoteDao = db.noteDao()