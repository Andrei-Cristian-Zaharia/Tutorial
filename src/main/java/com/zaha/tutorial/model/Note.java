package com.zaha.tutorial.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a simple Note entity.
 * This is the main domain object for this CRUD project.
 * <p>
 * A Note has a title, body text, and timestamps for when it was created and last updated.
 */
public class Note {

    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public Note() {
    }

    public Note(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Note{" + "id=" + id + ", title='" + title + '\'' +
                ", createdAt=" + createdAt.format(formatObj) +
                ", updatedAt=" + updatedAt.format(formatObj) +
                ", body= '" + body + "'}";
    }

    // [DONE] TODO: Create a constructor with id, title and body as parameters
    //       and initialize createdAt and updatedAt with the current time
    // [DONE] TODO: Implement getters and setters for all fields
    // [DONE] TODO: Override toString() to provide a readable representation of a Note
}
