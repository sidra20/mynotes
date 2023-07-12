package com.mynotess21.mynotes.di

import com.mynotess21.core.iLocalData.INoteDataSource
import com.mynotess21.local_data_source.NoteLocalDataImpl
import org.koin.dsl.module

val localDataModule = module {
    factory<INoteDataSource> { NoteLocalDataImpl(get()) }
}