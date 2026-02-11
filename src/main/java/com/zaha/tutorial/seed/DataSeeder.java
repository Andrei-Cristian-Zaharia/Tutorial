package com.zaha.tutorial.seed;

import com.zaha.tutorial.model.Note;
import com.zaha.tutorial.repository.NoteRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Seeds the in-memory repository with sample data on application startup.
 *
 * CommandLineRunner is a Spring Boot interface — any bean implementing it
 * will have its run() method called automatically when the application starts.
 *
 * These notes are sample data so you can test the API right away
 * without having to create notes manually first.
 */
//[DONE] TODO: After implementing the repository, uncomment this class to load sample data.
@Component
public class DataSeeder implements CommandLineRunner {

    private final NoteRepository noteRepository;

    public DataSeeder(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String @NonNull ... args)  {
        Note note1 = new Note(1L, "T1", "body1");
        Note note2 = new Note(2L, "T2", "body2");
        Note note3 = new Note(3L, "T3", "body3");
        noteRepository.save(note1);
        noteRepository.save(note2);
        noteRepository.save(note3);
        noteRepository.save(note1);
        System.out.println("find by id2: " + noteRepository.findById(2L));
        System.out.println("find all: " + noteRepository.findAll());


//      [DONE] TODO: Create 3 sample notes and save them to the repository by using the repository's save() method
    }
}
