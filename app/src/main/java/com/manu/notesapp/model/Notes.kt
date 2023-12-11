package com.manu.notesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    var subTitle: String,
    var notes: String,
    var date: String,
    var priority: String
)