package ru.adanilov.front;

import ru.adanilov.domain.Note;
import ru.adanilov.domain.User;
import ru.adanilov.repository.NotesRepository;
import ru.adanilov.service.Session;

import javax.swing.*;
import java.util.List;

public class NotesFrontend implements Frontend{
    private final NotesRepository notesRepository;

    public NotesFrontend(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public void start(Session session) {

        User user = session.unwrap();
        List<Note> notes = notesRepository.getAllByUsername(user.getUsername());

        JOptionPane.showMessageDialog(
                null,
                "Current notes: " + notes.toString(),
                "Notes",
                JOptionPane.INFORMATION_MESSAGE);

        String newNoteText = JOptionPane.showInputDialog("New note: ");
        notesRepository.saveNote(
                new Note(
                        user.getUsername(),
                        newNoteText)
        );
        int exit = JOptionPane.showConfirmDialog(
                null,
                "Proceed?",
                null,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (exit == JOptionPane.YES_OPTION) {
            this.start(session);
        }
    }
}
