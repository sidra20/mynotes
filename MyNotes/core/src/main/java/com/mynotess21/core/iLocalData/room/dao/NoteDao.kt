package com.mynotess21.core.iLocalData.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mynotess21.core.models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM note")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteSelectedNotes(notes:List<Note>)

    @Query("SELECT * FROM note WHERE id= :id")
    suspend fun getNote(id:Int) : Note?

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<Note>>
}