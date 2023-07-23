package com.mynotess21.core.iLocalData

import androidx.lifecycle.LiveData
import com.mynotess21.core.models.Note

interface INoteDataSource {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun getNote(id:Int) : Note?
    suspend fun deleteAllNotes()
    suspend fun deleteSelectedNotes(notes:List<Note>)
    fun getAllNotes() : LiveData<List<Note>>

}