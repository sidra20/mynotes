package com.mynotess21.core.iService

import androidx.lifecycle.LiveData
import com.mynotess21.core.models.Note

interface INoteService {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun getNote(id:Int) : Note?
    suspend fun deleteAllNotes()
    fun getAllNotes() : LiveData<List<Note>>
}