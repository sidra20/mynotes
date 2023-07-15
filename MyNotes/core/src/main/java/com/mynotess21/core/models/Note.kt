package com.mynotess21.core.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var title:String,
    var NoteDesc:String,
    var date:String,
    var time:String,
)
