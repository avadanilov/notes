package ru.adanilov.front;

import ru.adanilov.service.Session;

public interface Frontend {

    void start(Session session);

    class MockFrontend implements Frontend {

        @Override
        public void start(Session session) {
            System.out.println("started!!!");
        }
    }

}
