package com.lambdaschool.notetaker

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.lambdaschool.notetakerroom.NotesRoomDB


class NoteRepository(context: Context) {

   // val notes = arrayListOf<Note>()

    private val notesFromCache: ArrayList<Note>
        get() = NotesDbDao.readAllNotes()

    private val database by lazy {
        return@lazy Room.databaseBuilder(
            context.applicationContext,
            NotesRoomDB::class.java, "notes_database"
        ).fallbackToDestructiveMigration().build()
    }

    /*public NoteRepository() {
        this.notes = new ArrayList<>();
    }*/

    fun getNotes(context: Context): MutableLiveData<ArrayList<Note>> {
        Companion.liveDataList = MutableLiveData()
        NotesDbDao.initializeInstance(context)
        // retrieve notes from cache
        val ldList = Companion.liveDataList
        ldList.value = notesFromCache
        // retrieve notes from online DB
        Thread(Runnable {
            val notes = database.notesDao().getNotes()
            ldList.postValue(ArrayList(notes))
        }).start()
        return ldList
    }

    fun addNote(note: Note): java.util.ArrayList<Note> {
        Thread(Runnable {
            database.notesDao().createNote(note)
            Companion.liveDataList.postValue(notesFromCache)
        }).start()
        return SharedPrefsDao.allNotes
    }

    companion object {
        lateinit var liveDataList: MutableLiveData<ArrayList<Note>>
    }
}
