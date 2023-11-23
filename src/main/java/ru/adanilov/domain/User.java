package ru.adanilov.domain;

public class User {
    public String getUsername() {
        return username;
    }

    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isPasswordEquals(String passwordHash) {
        return password.equals(passwordHash);
    }
}
