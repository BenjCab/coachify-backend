package com.switchfully.youcoach.domain.entities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoacheeTest {

    @Test
    void givenUserWithFirstNameNull_thenThrowsIllegalArgumentException() {
        //WHEN
        Coachee coachee1 = new Coachee();
        //Then
        assertThrows(IllegalArgumentException.class, () -> coachee1.setFirstName(null));
    }

    @Test
    void givenUserWithLastNameBlank_thenThrowsIllegalArgumentException() {
        //WHEN
        Coachee coachee1 = new Coachee();
        //Then
        assertThrows(IllegalArgumentException.class, () -> coachee1.setLastName("     "));
    }

    @Test
    void givenUserWithWrongEmail_thenThrowsIllegalArgumentException() {
        //WHEN
        Coachee coachee1 = new Coachee();
        //Then
        assertThrows(IllegalArgumentException.class, () -> coachee1.setEmail("testtest.co"));
    }
}
