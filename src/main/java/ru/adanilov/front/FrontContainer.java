package ru.adanilov.front;

import ru.adanilov.front.Frontend;
import ru.adanilov.service.Session;

public class FrontContainer implements Frontend {
    private final Frontend[] frontends;

    public FrontContainer(Frontend... frontends) {
        this.frontends = frontends;
    }
    @Override
    public void start(Session session) {
        for (Frontend frontend : frontends) {
            frontend.start(session);
        }
    }
}
