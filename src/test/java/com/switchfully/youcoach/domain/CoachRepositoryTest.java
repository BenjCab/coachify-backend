package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CoachRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Test
    void shouldSave() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Summer")
                .setLastName("Smith")
                .setEmail("test@test.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        accountRepository.save(account);

        CoachProfile coachProfile = CoachProfile.builder()
                .setAccount(account)
                .setAvailability("testing")
                .setImage("assets/images/testImage")
                .setIntroduction("test introduction")
                .build();

        coachRepository.save(coachProfile);

        coachRepository.delete(coachProfile);
        accountRepository.delete(account);
    }

    @Test
    void shouldReturnAllCoaches() {
        List<CoachProfile> coachProfiles = coachRepository.findAll();

        Assertions.assertTrue(coachProfiles.get(0).getAccount().getAuthorities().contains(Authority.COACH));
    }

    @Test
    void shouldFindUserById() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Foo")
                .setLastName("Bar")
                .setEmail("account@test.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        accountRepository.save(account);

        CoachProfile coachProfile = CoachProfile.builder()
                .setAccount(account)
                .setAvailability("testing")
                .setImage("assets/images/testImage")
                .setIntroduction("test introduction")
                .build();

        coachRepository.save(coachProfile);

        CoachProfile coachProfile1 = coachRepository.findById(coachProfile.getId()).orElseThrow();

        Assertions.assertEquals(coachProfile.getIntroduction(), coachProfile1.getIntroduction());
        Assertions.assertEquals(coachProfile.getId(), coachProfile1.getId());
        Assertions.assertEquals(coachProfile.getAvailability(), coachProfile1.getAvailability());
        Assertions.assertEquals(coachProfile.getImage(), coachProfile1.getImage());

        coachRepository.delete(coachProfile);
        accountRepository.delete(account);

    }
}
