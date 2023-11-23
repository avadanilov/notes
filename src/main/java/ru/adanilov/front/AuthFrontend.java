package ru.adanilov.front;

import ru.adanilov.domain.User;
import ru.adanilov.repository.UserRepository;
import ru.adanilov.service.PasswordService;
import ru.adanilov.service.Session;

import javax.swing.*;
import java.util.Optional;

public class AuthFrontend implements Frontend {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public AuthFrontend(UserRepository userRepository,
                        PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public void start(Session session) {
        final String login = JOptionPane.showInputDialog("Login:");
        final String password = JOptionPane.showInputDialog("Password:");

        String hash = this.passwordService.encode(password);

        Optional<User> userFromDb = userRepository.getByUsername(login);
        if (userFromDb.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid username or password",
                    "Authentification error",
                    JOptionPane.ERROR_MESSAGE
            );
            this.start(session);
        } else {
            User user = userFromDb.get();
            if (userFromDb.get().isPasswordEquals(hash)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Success authentification!",
                        "Info", JOptionPane.INFORMATION_MESSAGE
                );
                session.setUser(user);
            }
        }


        System.out.printf("AuthFrontend started!");
    }
}
