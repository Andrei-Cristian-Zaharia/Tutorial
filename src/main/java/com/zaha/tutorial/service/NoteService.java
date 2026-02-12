package com.zaha.tutorial.service;

import com.zaha.tutorial.model.Note;
import com.zaha.tutorial.repository.NoteRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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


    // [DONE] TODO: Implement this method to return all notes.
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // [DONE] TODO: Implement this method to return a single note by ID.
    // - Validate the incoming id (null check).
    // - Consider throwing a specific exception for invalid input or returning Optional.empty().
    public Optional<Note> getNoteById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return noteRepository.findById(id);
    }

    // [DONE] TODO: Implement createNote:
    // - Validate title and body are present (non-null, non-empty). If invalid, throw IllegalArgumentException.
    // - Save via noteRepository.save(note) and return the saved entity.
    public Note createNote(Note note) {
        if (note.getTitle().isEmpty() || note.getTitle() == null
                || note.getBody().isEmpty() || note.getBody() == null){
            throw new IllegalArgumentException("Invalid title or body");
        }
        return noteRepository.save(note);
    }

    // [DONE] TODO: Implement updateNote:
    // - Validate id and updatedNote payload.
    // - Retrieve existing note via noteRepository.findById(id).
    // - If present, update fields (title, body, updatedAt) and save if your repository supports update.
    // - Return Optional.of(updatedNote) or Optional.empty() if not found.
    public Optional<Note> updateNote(Long id, Note updatedNote) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid id");
        }
        Optional<Note> existingNote = noteRepository.findById(id);
        if (existingNote.isPresent()){
            noteRepository.updateById(id, updatedNote.getTitle(), updatedNote.getBody());
            noteRepository.save(updatedNote);
            return Optional.of(updatedNote);
        } else {
            return Optional.empty();
        }
    }

    // [DONE] TODO: Implement deleteNote:
    // - Validate id.
    public boolean deleteNote(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid id");
        }
        return noteRepository.deleteById(id);
    }
}
