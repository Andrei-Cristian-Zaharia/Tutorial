package com.zaha.tutorial.model;

import java.time.LocalDateTime;

/**
 * Represents a simple Note entity.
 * This is the main domain object for this CRUD project.
 *
 * A Note has a title, body text, and timestamps for when it was created and last updated.
 */
public class Note {

    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public Note() {}

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    // TODO: Create a constructor with id, title and body as parameters and initialize createdAt and updatedAt with the current time
    // TODO: Implement getters and setters for all fields
    // TODO: Override toString() to provide a readable representation of a Note
}
