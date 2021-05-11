package com.switchfully.youcoach.infrastructure.email;

import com.switchfully.youcoach.domain.Event;

public interface MessageSender {
    void handle(Event event);
}
