# Notes API — CRUD Learning Project

## Project Description

This is a simple REST API for managing **Notes**. A note has a title, body text, and automatic timestamps.

The project models a basic note-taking application — think of it like a simplified backend for a sticky notes app.

**This project is intentionally incomplete.** It contains working starter code, but many parts are left as `TODO` placeholders for you to implement. The goal is to learn backend development by filling in the missing pieces yourself.

---

## Available Endpoints

| Method   | Path           | Description                        |
|----------|----------------|------------------------------------|
| `GET`    | `/notes`       | Returns all notes                  |
| `GET`    | `/notes/{id}`  | Returns a single note by its ID    |
| `POST`   | `/notes`       | Creates a new note                 |
| `PUT`    | `/notes/{id}`  | Replaces an existing note          |
| `PATCH`  | `/notes/{id}`  | Partially updates an existing note |
| `DELETE` | `/notes/{id}`  | Deletes a note by its ID           |

> Note: `PATCH` is an optional exercise in this project and may not be implemented by default — it's included here as an exercise to add partial updates.

---

## Exercises

The exercises are split into two parts:

PART 1 — Implement every `TODO` that exists in the codebase (these are the base tasks required to make the starter app functional). Each item below includes the file path, the TODO text found in code, and acceptance criteria.

1) src/main/java/com/zaha/tutorial/service/NoteService.java
   - TODOs found:
     - `// TODO: Implement this method to return all notes.` (getAllNotes)
     - `// TODO: Implement this method to return a single note by ID.` (getNoteById)
     - `// TODO: Implement createNote:` (createNote)
     - `// TODO: Implement updateNote:` (updateNote)
     - `// TODO: Implement deleteNote:` (deleteNote)
   - Acceptance criteria:
     - `getAllNotes()` returns all notes from the repository (List<Note>).
     - `getNoteById(Long id)` validates `id` and returns `Optional<Note>` from repository; returns Optional.empty() for null/unknown id.
     - `createNote(Note note)` validates `title` and `body` (non-null, non-empty), sets `createdAt` and `updatedAt` to now, saves via `noteRepository.save(...)`, and returns saved note.
     - `updateNote(Long id, Note updatedNote)` finds existing note by id, updates `title`, `body`, and `updatedAt`, and returns Optional.of(updated) or Optional.empty() when not found.
     - `deleteNote(Long id)` validates id and removes the note, returning true if deleted and false otherwise.

2) src/main/java/com/zaha/tutorial/repository/NoteRepository.java
   - TODOs found:
     - `// TODO: Implement this method to return a note with the given ID` (findById)
     - `// TODO: Implement this method to delete a note with the given ID` (deleteById)
     - `// TODO: Implement an update method that finds an existing note by ID and replaces its fields.`
     - `// TODO: Implement a method to check if a note with a given ID exists (existsById).`
   - Acceptance criteria:
     - `findById(Long id)` returns Optional.of(note) when found, Optional.empty() otherwise; handle null id safely.
     - `deleteById(Long id)` removes the note by id and returns whether deletion occurred.
     - `update(Note note)` (or `updateById(Long id, Note updates)`) modifies the existing in-memory entry.
     - `existsById(Long id)` returns true/false and can be used by service/controller logic.

3) src/main/java/com/zaha/tutoria l/controller/NoteController.java
   - TODOs found in each endpoint method (getAllNotes, getNoteById, createNote, updateNote, deleteNote): `// TODO: Implement endpoint behavior`
   - Acceptance criteria:
     - Controller endpoints call the corresponding service methods.
     - Map service results to appropriate HTTP responses:
       - 200 OK with body for successful GET/PUT
       - 201 Created for successful POST (include body)
       - 204 No Content for successful DELETE
       - 400 Bad Request for validation failures
       - 404 Not Found when resource is missing
     - Prefer returning structured JSON error bodies (optional: via `@ControllerAdvice`).

4) src/main/java/com/zaha/tutorial/seed/DataSeeder.java
   - TODOs found:
     - `//TODO: After implementing the repository, uncomment this class to load sample data.`
     - `//      TODO: Create 3 sample notes and save them to the repository by using the repository's save() method`
   - Acceptance criteria:
     - Un-comment the `@Component` DataSeeder when repository methods are implemented.
     - `run()` should create and save 3 sample notes so that the app has data on startup.

Notes on PART 1
- These TODOs are the minimal, required work to make the provided starter API functional. Implementing them in the order above (repository → service → controller → seeder) is recommended because higher layers depend on lower layers.

---

PART 2 — Remaining exercises (higher-level or optional tasks already present in the README)

These are the remaining exercises from the README (kept as higher-level or optional challenges). Work on these after completing PART 1.

1. Add `PATCH /notes/{id}` (advanced)
   - Allow partial updates; only change fields present in the request. Consider a nullable DTO or `JsonMerge` behavior.

2. Pagination, filtering, and sorting (optional)
   - Add pagination to `GET /notes` and/or add filtering by title and sorting by `createdAt` or `title`.

3. Replace the in-memory storage with Spring Data JPA (advanced)
   - Implement a JPA-backed repository using H2 (in-memory) for easy local tests or MySQL for a persistent store.
   - Add entity annotations, repository interfaces, and migration scripts if needed.

4. Add tests and CI (recommended)
   - Unit tests for the service layer (JUnit + Mockito).
   - Integration tests for controller endpoints (Spring Boot Test or TestRestTemplate).

5. Add OpenAPI/Swagger docs (optional)
   - Use `springdoc-openapi` to auto-generate API docs and make it easy to explore endpoints.

6. Add structured error responses and global exception handling
   - Create an error response class and an `@ControllerAdvice` to centralize mapping exceptions to HTTP responses (400/404/500).

7. Polish and extras (bonus)
   - Add `toString()` to the `Note` model for better logging.
   - Improve logging and add a simple request/response logging filter.
   - Add DTOs if you want to decouple internal model from API surface.

---

After completing PART 1 and PART 2, update this README to mark completed exercises and add any notes about edge cases you discovered while implementing the code.
