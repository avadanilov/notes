package ru.adanilov;

import ru.adanilov.front.AuthFrontend;
import ru.adanilov.front.FrontContainer;
import ru.adanilov.front.NotesFrontend;
import ru.adanilov.repository.FileUserRepository;
import ru.adanilov.repository.NotesRepository;
import ru.adanilov.repository.UserRepository;
import ru.adanilov.service.Base64PasswordService;
import ru.adanilov.service.PasswordService;
import ru.adanilov.service.UserSession;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        new FrontContainer(
                new AuthFrontend(
                        new FileUserRepository(
                                Path.of("users.csv")
                        ),
                        new Base64PasswordService()
                ),
                new NotesFrontend(
                        new NotesRepository.MockNotesRepository()
                )
        ).start(new UserSession());
    }
}