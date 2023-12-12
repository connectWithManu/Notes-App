package com.manu.notesapp.repository

import androidx.lifecycle.LiveData
import com.manu.notesapp.model.Notes
import com.manu.notesapp.room.NotesDao

class NotesRepository(private val dao: NotesDao) {
    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun getLowNotes(): LiveData<List<Notes>> = dao.getLowNotes()
    fun getMediumNotes(): LiveData<List<Notes>> = dao.getMediumNotes()
    fun getHighNotes(): LiveData<List<Notes>> = dao.getHighNotes()

    fun insetNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }




}