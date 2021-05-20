package com.switchfully.youcoach;

import com.switchfully.youcoach.domain.*;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class YoucoachApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(YoucoachApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YoucoachApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeUsers(@Autowired AccountRepository accountRepository,
                                             @Autowired CoachRepository coachRepository,
                                             @Autowired TopicByCoachRepository topicByCoachRepository,
                                             @Autowired TopicRepository topicRepository,
                                             @Autowired PasswordEncoder passwordEncoder) {
        return (args) -> {
            AccountImpl account1 = AccountImpl.builder()
                    .setFirstName("Testa")
                    .setLastName("Test")
                    .setEmail("test@test.com")
                    .setPassword(passwordEncoder.encode("password"))
                    .setEnabled(true)
                    .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                    .build();

            AccountImpl account2 = AccountImpl.builder()
                    .setFirstName("Bart")
                    .setLastName("Simpson")
                    .setEmail("bart@test.com")
                    .setPassword(passwordEncoder.encode("password"))
                    .setEnabled(true)
                    .setAuthorities(List.of(Authority.COACHEE))
                    .build();

            AccountImpl account3 = AccountImpl.builder()
                    .setFirstName("Marge")
                    .setLastName("Simpson")
                    .setEmail("marge@test.com")
                    .setPassword(passwordEncoder.encode("Password1"))
                    .setEnabled(true)
                    .setAuthorities(List.of(Authority.COACH, Authority.ADMIN, Authority.COACHEE))
                    .build();

            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);

            CoachProfile coachProfile1 = new CoachProfile().setAccount(account3).setAvailability("Sunday").setImage("./assets/images/profile-picture-coach.png").setIntroduction("intro");
            CoachProfile coachProfile2 = new CoachProfile().setAccount(account1).setAvailability("Monday").setImage("./assets/images/profile-picture-coach.png").setIntroduction("intro");

            coachRepository.save(coachProfile1);
            coachRepository.save(coachProfile2);

            Topic python = new Topic().setTopicName("Python");
            Topic angular = new Topic().setTopicName("Angular");

            topicRepository.save(python);
            topicRepository.save(angular);

            TopicByCoach topicByCoach1 = new TopicByCoach().setTopic(python).setCoachProfile(coachProfile1).setGrade1(true).setGrade2(true).setGrade3(false);
            TopicByCoach topicByCoach2 = new TopicByCoach().setTopic(angular).setCoachProfile(coachProfile1).setGrade1(true).setGrade2(true).setGrade3(false);
            TopicByCoach topicByCoach3 = new TopicByCoach().setTopic(angular).setCoachProfile(coachProfile2).setGrade1(true).setGrade2(true).setGrade3(true);

            topicByCoachRepository.save(topicByCoach1);
            topicByCoachRepository.save(topicByCoach2);
            topicByCoachRepository.save(topicByCoach3);

            LOGGER.info("Added user: " + account1);
            LOGGER.info("Added user: " + account2);
            LOGGER.info("Added user: " + account3);
        };
    }

}
