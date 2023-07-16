package com.mynotess21.core.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var title:String,
    var NoteDesc:String,
    var date:String?=null,
    var time:String?=null,
):Parcelable
