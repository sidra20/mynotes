package com.mynotess21.mynotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynotess21.core.iService.INoteService
import com.mynotess21.core.models.Note
import kotlinx.coroutines.launch

class NotesViewModel(private val iNoteService: INoteService) : ViewModel() {
//     private val _getAllNotes : MutableLiveData<List<Note>> = MutableLiveData()
//     val getAllNotes:LiveData<List<Note>>
//          get() = _getAllNotes

     val getMyNotes = iNoteService.getAllNotes()

     init {

     }

     fun insertNote(note: Note) = viewModelScope.launch {
          iNoteService.insertNote(note)
     }
     fun deleteNote(note: Note) = viewModelScope.launch {
          iNoteService.deleteNote(note)
     }
     fun updateNote(note: Note) = viewModelScope.launch {
          iNoteService.updateNote(note)
     }
     fun deleteAllNotes() = viewModelScope.launch {
          iNoteService.deleteAllNotes()
     }
     fun getNote(id:Int) = viewModelScope.launch {
          iNoteService.getNote(id)
     }
}