package com.mynotess21.service

import androidx.lifecycle.LiveData
import com.mynotess21.core.iLocalData.INoteDataSource
import com.mynotess21.core.iService.INoteService
import com.mynotess21.core.models.Note

class NoteServiceImpl(private val noteLocalDataSource: INoteDataSource ) : INoteService {
    override suspend fun insertNote(note: Note) {
        noteLocalDataSource.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteLocalDataSource.deleteNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteLocalDataSource.updateNote(note)
    }

    override suspend fun getNote(id: Int): Note? {
        return noteLocalDataSource.getNote(id)
    }

    override suspend fun deleteAllNotes() {
        noteLocalDataSource.deleteAllNotes()
    }

    override fun getAllNotes(): LiveData<List<Note>> {
        return noteLocalDataSource.getAllNotes()
    }
}