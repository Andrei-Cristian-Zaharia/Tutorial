package com.zaha.tutorial.repository;

import com.zaha.tutorial.model.Note;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory repository for Note entities.
 * <p>
 * This class uses a simple ArrayList to store notes instead of a real database.
 * It simulates what a database repository would do: store, retrieve, update, and delete records.
 * <p>
 * Later, the learner can replace this with a real database-backed repository
 * (e.g., using Spring Data JPA).
 */
@Repository
public class NoteRepository {

    // This list acts as our "database" — all notes are stored here in memory.
    // When the application restarts, all data is lost.
    private final List<Note> notes = new ArrayList<>();

    // AtomicLong generates unique IDs for each new note, similar to an auto-increment column.
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Note> findAll() {
        return new ArrayList<>(notes);
    }

    public Note save(Note note) {
        note.setId(idCounter.getAndIncrement());
        notes.add(note);
        return note;
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
        // [DONE] TODO: Implement this method to return a note with the given ID
    }

    public boolean deleteById(Long id) {
        return notes.removeIf(note -> note.getId().equals(id));
        // [DONE] TODO: Implement this method to delete a note with the given ID
    }

    public Optional<Note> updateById(Long id, String title, String body) {
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .map( note -> {
                    note.setTitle(title);
                    note.setBody(body);
                    note.setUpdatedAt(LocalDateTime.now());
                    return note;
                });
    }

    public boolean existById(Long id){
        return findById(id).isPresent();
    }

    // [DONE] TODO: Implement an update method that finds an existing note by ID and replaces its fields.
    //       Think about: what should happen if the note does not exist?

    // [DONE] TODO: Implement a method to check if a note with a given ID exists (existsById).
}
