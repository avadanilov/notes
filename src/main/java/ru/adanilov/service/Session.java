package ru.adanilov.service;

import ru.adanilov.domain.User;

public interface Session {
    Session setUser(User user);

    User unwrap();

    class EmptySession implements Session {
        @Override
        public Session setUser(User user) {
            return new UserSession(user);
        }
        @Override
        public User unwrap() {
            throw new IllegalStateException("Can`t unwrap EmptySession");
        }
    }
}
