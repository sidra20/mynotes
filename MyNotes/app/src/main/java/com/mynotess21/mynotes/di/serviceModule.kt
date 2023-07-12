package com.mynotess21.mynotes.di

import com.mynotess21.core.iService.INoteService
import com.mynotess21.service.NoteServiceImpl
import org.koin.dsl.module

val serviceModule = module{
    factory<INoteService> { NoteServiceImpl(get()) }
}