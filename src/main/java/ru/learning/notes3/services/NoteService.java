package ru.learning.notes3.services;

import ru.learning.notes3.models.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    void saveNote(Note note);

    void deleteNote(int id);
}
