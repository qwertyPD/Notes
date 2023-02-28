package ru.learning.notes3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learning.notes3.models.Note;
import ru.learning.notes3.repositories.NoteRepositoryImpl;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepositoryImpl noteRepository;
    @Autowired
    public NoteServiceImpl(NoteRepositoryImpl noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.getAllNotes();
    }

    @Override
    public void saveNote(Note note) {
        noteRepository.saveNote(note);
    }

    @Override
    public void deleteNote(int id) {
        noteRepository.deleteNote(id);
    }
}
