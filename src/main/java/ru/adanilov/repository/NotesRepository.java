package ru.adanilov.repository;

import ru.adanilov.domain.Note;
import ru.adanilov.domain.User;

import java.util.*;

public interface NotesRepository {
    List<Note> getAllByUsername(String username);

    void saveNote(Note note);
    class MockNotesRepository implements NotesRepository {

        private final List<Note> stored = new ArrayList<>(
                List.of(
                        new Note("dima", "first note!"),
                        new Note("dima", "second note!")
                ));
        @Override
        public List<Note> getAllByUsername(String username) {
            if ("dima".equals(username))
                return stored;
            return Collections.emptyList();
        }

        @Override
        public void saveNote(Note note) {
            stored.add(note);
        }
    }

}
