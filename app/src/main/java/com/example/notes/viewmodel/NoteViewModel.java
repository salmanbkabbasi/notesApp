package com.example.notes.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.notes.database.AppDatabase;
import com.example.notes.database.Note;
import com.example.notes.database.NoteDao;
import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        noteDao = db.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() { return allNotes; }

    public void insert(Note note) {
        new Thread(() -> noteDao.insert(note)).start();
    }

    public void update(Note note) {
        new Thread(() -> noteDao.update(note)).start();
    }

    public void delete(Note note) {
        new Thread(() -> noteDao.delete(note)).start();
    }
}