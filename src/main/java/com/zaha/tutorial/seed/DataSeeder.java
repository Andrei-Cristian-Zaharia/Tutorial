package com.zaha.tutorial.seed;

import com.zaha.tutorial.model.Note;
import com.zaha.tutorial.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Seeds the in-memory repository with sample data on application startup.
 *
 * CommandLineRunner is a Spring Boot interface — any bean implementing it
 * will have its run() method called automatically when the application starts.
 *
 * These notes are sample data so you can test the API right away
 * without having to create notes manually first.
 */
//TODO: After implementing the repository, uncomment this class to load sample data.
//@Component
//public class DataSeeder implements CommandLineRunner {
//
//    private final NoteRepository noteRepository;
//
//    public DataSeeder(NoteRepository noteRepository) {
//        this.noteRepository = noteRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//      TODO: Create 3 sample notes and save them to the repository by using the repository's save() method
//    }
//}
