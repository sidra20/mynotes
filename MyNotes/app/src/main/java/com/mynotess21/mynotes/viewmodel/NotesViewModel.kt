package com.mynotess21.mynotes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynotess21.core.iService.INoteService
import com.mynotess21.core.models.Note
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Locale

class NotesViewModel(private val iNoteService: INoteService) : ViewModel() {
//     private val _getAllNotes : MutableLiveData<List<Note>> = MutableLiveData()
//     val getAllNotes:LiveData<List<Note>>
//          get() = _getAllNotes

     val title = MutableLiveData<String>()
     val noteId = MutableLiveData<Int>()
     val note = MutableLiveData<String>()

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
     fun deleteSelectedNotes(notes:List<Note>) = viewModelScope.launch {
          iNoteService.deleteSelectedNotes(notes)
     }
     fun createNote(){
          val title = title.value.toString()
          val noteDes = note.value.toString()
          val formatter = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
          val date = Date()
          val currentDate = formatter.format(date)
          val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)
          val currentTime = timeFormat.format(date.time)
          insertNote(Note(title = title, NoteDesc = noteDes, date = currentDate, time = currentTime))
          Log.d("insert", "createNote: $currentDate  $currentTime " )
     }

     fun editNote(){
          val title = title.value.toString()
          val noteDes = note.value.toString()
          val id = noteId.value
          updateNote(Note(id=id,title=title, NoteDesc = noteDes))
     }

     fun setArguments(notes: Note){
          noteId.value = notes.id?.toInt()
          title.value = notes.title
          note.value = notes.NoteDesc
     }

}