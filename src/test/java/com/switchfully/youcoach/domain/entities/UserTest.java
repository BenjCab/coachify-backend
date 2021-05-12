package com.switchfully.youcoach.domain.entities;
import com.switchfully.youcoach.domain.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void givenUserWithFirstNameNull_thenThrowsIllegalArgumentException() {
        //WHEN
        User user1 = new User();
        //Then
        assertThrows(IllegalArgumentException.class, () -> user1.setFirstName(null));
    }

    @Test
    void givenUserWithLastNameBlank_thenThrowsIllegalArgumentException() {
        //WHEN
        User user1 = new User();
        //Then
        assertThrows(IllegalArgumentException.class, () -> user1.setLastName("     "));
    }

    @Test
    void givenUserWithWrongEmail_thenThrowsIllegalArgumentException() {
        //WHEN
        User user1 = new User();
        //Then
        assertThrows(IllegalArgumentException.class, () -> user1.setEmail("testtest.co"));
    }
}
