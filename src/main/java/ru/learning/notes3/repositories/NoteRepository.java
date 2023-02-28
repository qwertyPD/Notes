package ru.learning.notes3.repositories;

import ru.learning.notes3.models.Note;

import java.util.List;

public interface NoteRepository {
    List<Note> getAllNotes();

    void saveNote(Note note);

    void deleteNote(int id);
}
