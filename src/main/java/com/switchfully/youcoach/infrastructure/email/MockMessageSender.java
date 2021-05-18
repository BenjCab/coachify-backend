package com.switchfully.youcoach.infrastructure.email;

import com.switchfully.youcoach.domain.Event;
import com.switchfully.youcoach.infrastructure.email.MessageSender;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"test", "development", "production"})
@Component
public class MockMessageSender implements MessageSender {

    @Override
    public void handle(Event event) {
        //Send your messages here...
    }
}
