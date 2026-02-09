package com.zaha.tutorial.service;

import com.zaha.tutorial.model.Note;
import com.zaha.tutorial.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service layer for Note operations.
 *
 * The service layer sits between the controller and the repository.
 * It contains business logic — things like validation, transformations, or rules
 * that should happen before data is saved or returned.
 *
 * Right now, most methods are thin wrappers around the repository.
 * Your task is to add proper logic where indicated by TODO comments.
 */
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    // Spring automatically injects the NoteRepository here (constructor injection).
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // TODO: Implement this method to return all notes.
    public List<Note> getAllNotes() {
        throw new UnsupportedOperationException("getAllNotes() not implemented. See TODO in source for details.");
    }

    // TODO: Implement this method to return a single note by ID.
    // - Validate the incoming id (null check).
    // - Consider throwing a specific exception for invalid input or returning Optional.empty().
    public Optional<Note> getNoteById(Long id) {
        throw new UnsupportedOperationException("getNoteById() not implemented. See TODO in source for details.");
    }

    // TODO: Implement createNote:
    // - Validate title and body are present (non-null, non-empty). If invalid, throw IllegalArgumentException.
    // - Save via noteRepository.save(note) and return the saved entity.
    public Note createNote(Note note) {
        throw new UnsupportedOperationException("createNote() not implemented. See TODO in source for details.");
    }

    // TODO: Implement updateNote:
    // - Validate id and updatedNote payload.
    // - Retrieve existing note via noteRepository.findById(id).
    // - If present, update fields (title, body, updatedAt) and save if your repository supports update.
    // - Return Optional.of(updatedNote) or Optional.empty() if not found.
    public Optional<Note> updateNote(Long id, Note updatedNote) {
        throw new UnsupportedOperationException("updateNote() not implemented. See TODO in source for details.");
    }

    // TODO: Implement deleteNote:
    // - Validate id.
    public boolean deleteNote(Long id) {
        throw new UnsupportedOperationException("deleteNote() not implemented. See TODO in source for details.");
    }
}
