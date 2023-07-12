package com.mynotess21.local_data_source

import androidx.lifecycle.LiveData
import com.mynotess21.core.iLocalData.INoteDataSource
import com.mynotess21.core.iLocalData.room.dao.NoteDao
import com.mynotess21.core.models.Note

class NoteLocalDataImpl(private val noteDao: NoteDao) : INoteDataSource {
    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    override suspend fun getNote(id:Int): Note? {
        return noteDao.getNote(id)
    }

    override suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    override fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }
}