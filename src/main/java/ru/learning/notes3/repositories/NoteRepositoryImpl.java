package ru.learning.notes3.repositories;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.learning.notes3.models.Note;

import java.util.List;

@Repository
public class NoteRepositoryImpl implements NoteRepository {
    private final EntityManager entityManager;
    @Autowired
    public NoteRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Note> getAllNotes() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Note", Note.class).getResultList();
    }

    @Override
    @Transactional
    public void saveNote(Note note) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(note);
    }

    @Override
    @Transactional
    public void deleteNote(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(Note.class, id));
    }
}
