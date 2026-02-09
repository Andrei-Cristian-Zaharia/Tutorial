package com.zaha.tutorial.controller;

import com.zaha.tutorial.model.Note;
import com.zaha.tutorial.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Note endpoints.
 *
 * This controller maps HTTP requests to the Note service methods.
 * Each method handles one type of CRUD operation.
 *
 * Base path: /notes
 */
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        // TODO: Implement endpoint behavior
        // - Call noteService.getAllNotes()
        // - Return HTTP 200 with the list of notes
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        // TODO: Implement endpoint behavior
        // - Validate the id (null, negative values)
        // - Call noteService.getNoteById(id)
        // - If present, return HTTP 200 with the note
        // - If not present, return HTTP 404 with an optional error body
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        // TODO: Implement endpoint behavior
        // - Validate the incoming payload (title/body non-empty)
        // - Call noteService.createNote(note)
        // - Return HTTP 201 with the created note
        // - On validation failure, return HTTP 400 with an error message
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        // TODO: Implement endpoint behavior
        // - Validate id and payload
        // - Call noteService.updateNote(id, note)
        // - If the service returns an updated note, return HTTP 200
        // - If not found, return HTTP 404
        // - Consider distinguishing between validation errors (400) and not-found (404)
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        // TODO: Implement endpoint behavior
        // - Validate id
        // - Call noteService.deleteNote(id)
        // - If deleted, return HTTP 204
        // - If not found, return HTTP 404
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
