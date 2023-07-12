package com.mynotess21.mynotes.di

import com.mynotess21.mynotes.viewmodel.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NotesViewModel(get()) }
}