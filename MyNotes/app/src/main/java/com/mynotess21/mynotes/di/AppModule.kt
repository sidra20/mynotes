package com.mynotess21.mynotes.di

import android.content.Context
import androidx.room.Room
import com.mynotess21.core.iLocalData.INoteDataSource
import com.mynotess21.core.iLocalData.room.AppDatabase
import com.mynotess21.core.iLocalData.room.dao.NoteDao
import com.mynotess21.core.iService.INoteService
import com.mynotess21.local_data_source.NoteLocalDataImpl
import com.mynotess21.service.NoteServiceImpl
import org.koin.dsl.module

val AppModule = module{
    single { providesDatabase(get()) }
    single { providesNoteDao(get()) }
    factory<INoteDataSource> { NoteLocalDataImpl(get()) }
    factory<INoteService> { NoteServiceImpl(get()) }


}

//fun providesDatabase(context: Context): AppDatabase = Room.databaseBuilder(
//    context,
//    AppDatabase::class.java,
//    "mynotesdatabase"
//)
//    .fallbackToDestructiveMigration()
//    .build()
//
//fun providesNoteDao(db: AppDatabase): NoteDao = db.noteDao()