# 📝 Notes API — CRUD Learning Project

## 📖 Project Description

This is a simple REST API for managing **Notes**. A note has a title, body text, and automatic timestamps.

The project models a basic note-taking application — think of it like a simplified backend for a sticky notes app.

**This project is intentionally incomplete.** It contains working starter code, but many parts are left as `TODO` placeholders for you to implement. The goal is to learn backend development by filling in the missing pieces yourself.

---

## 🚀 How to Run

### Prerequisites

- **Java 21** (JDK 21 or newer)
- **Maven** (or use the included Maven wrapper: `mvnw` / `mvnw.cmd`)

### Start the application

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

**Mac / Linux:**
```bash
./mvnw spring-boot:run
```

The API will start on **http://localhost:8080**.

Three sample notes are automatically loaded when the application starts.

---

## 📡 Available Endpoints

| Method   | Path           | Description                        |
|----------|----------------|------------------------------------|
| `GET`    | `/notes`       | Returns all notes                  |
| `GET`    | `/notes/{id}`  | Returns a single note by its ID    |
| `POST`   | `/notes`       | Creates a new note                 |
| `PUT`    | `/notes/{id}`  | Updates an existing note           |
| `DELETE` | `/notes/{id}`  | Deletes a note by its ID           |

### Example: Create a note

```bash
curl -X POST http://localhost:8080/notes \
  -H "Content-Type: application/json" \
  -d '{"title": "My Note", "body": "This is a test note."}'
```

### Example: Get all notes

```bash
curl http://localhost:8080/notes
```

---

## 🧠 Learning Goals

By working on this project, you will practice:

- **CRUD operations** — Create, Read, Update, Delete
- **HTTP methods** — GET, POST, PUT, DELETE and when to use each
- **Request and response bodies** — Sending and receiving JSON
- **HTTP status codes** — 200, 201, 204, 400, 404 and what they mean
- **Layered architecture** — Controller → Service → Repository separation
- **Error handling** — Returning proper responses when something goes wrong
- **Java and Spring Boot basics** — Annotations, dependency injection, REST controllers

---

## 🛠️ Tasks for the Learner

Work through these tasks in order. Each one builds on the previous:

- [ ] **Implement the `updateNote` method in `NoteService`** — Find the existing note, update its fields, and return it.
- [ ] **Implement the `PUT /notes/{id}` endpoint in `NoteController`** — Wire it up to the service method you just wrote.
- [ ] **Add input validation in `NoteService.createNote()`** — Reject notes with empty or null titles/bodies.
- [ ] **Handle validation errors in `NoteController.createNote()`** — Catch exceptions and return HTTP 400.
- [ ] **Improve the 404 response in `getNoteById()`** — Return a JSON error body instead of an empty response.
- [ ] **Add `toString()` to the `Note` model** — Useful for logging and debugging.
- [ ] **Implement `existsById()` in `NoteRepository`** — A utility method to check if a note exists.
- [ ] **Implement `update()` in `NoteRepository`** — Update a note's fields in the in-memory list.
- [ ] **Replace in-memory storage with a real database** — Use Spring Data JPA with H2 or MySQL.
- [ ] **Add pagination to `GET /notes`** — Return notes in pages instead of all at once.

---

## 🧪 Optional Challenges

If you finish the tasks above and want more practice:

- [ ] **Add search/filtering** — Find notes by title (e.g., `GET /notes?title=shopping`).
- [ ] **Add sorting** — Sort notes by creation date or title (e.g., `GET /notes?sort=createdAt`).
- [ ] **Add unit tests** — Write tests for the service layer using JUnit and Mockito.
- [ ] **Add Swagger/OpenAPI docs** — Use `springdoc-openapi` to auto-generate API documentation.
- [ ] **Create an error response class** — A reusable object for returning structured error messages.
- [ ] **Add a `PATCH` endpoint** — Allow partial updates (only update the fields that are provided).

---

## 📁 Project Structure

```
src/main/java/com/zaha/tutorial/
├── TutorialApplication.java        # Main entry point
├── controller/
│   └── NoteController.java         # REST endpoints
├── service/
│   └── NoteService.java            # Business logic (has TODOs)
├── repository/
│   └── NoteRepository.java         # In-memory data storage (has TODOs)
├── model/
│   └── Note.java                   # The Note entity
└── seed/
    └── DataSeeder.java             # Loads sample data on startup
```

---

## 💡 Tips

- Use a tool like **Postman**, **Insomnia**, or **curl** to test the API.
- Read the TODO comments in the code — they explain exactly what to do.
- Start with the service layer, then move to the controller.
- When in doubt, look at how the existing working methods are implemented and follow the same pattern.
- Don't be afraid to experiment — the data resets every time you restart the app!
