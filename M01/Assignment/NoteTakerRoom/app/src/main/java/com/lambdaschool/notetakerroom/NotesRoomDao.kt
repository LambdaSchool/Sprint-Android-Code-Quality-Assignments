package com.lambdaschool.notetakerroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesRoomDao {

    @Insert
    fun createNote(note: Note): Long

    @Query("SELECT * FROM note")
    fun getNotes(): List<Note>

}