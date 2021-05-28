package com.switchfully.youcoach.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopicTest {

    @Test
    void givenTopicWithTopicNameNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Topic()
                .setTopicName(null));
    }


}
