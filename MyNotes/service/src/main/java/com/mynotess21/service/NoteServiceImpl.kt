package com.mynotess21.service

import androidx.lifecycle.LiveData
import com.mynotess21.core.iService.INoteService
import com.mynotess21.core.models.Note

class NoteServiceImpl(private val noteLocalDataImpl: NoteServiceImpl) : INoteService {
    override suspend fun insertNote(note: Note) {
        noteLocalDataImpl.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteLocalDataImpl.deleteNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteLocalDataImpl.updateNote(note)
    }

    override suspend fun getNote(id: Int): Note? {
        return noteLocalDataImpl.getNote(id)
    }

    override suspend fun deleteAllNotes() {
        noteLocalDataImpl.deleteAllNotes()
    }

    override fun getAllNotes(): LiveData<List<Note>> {
        return noteLocalDataImpl.getAllNotes()
    }
}