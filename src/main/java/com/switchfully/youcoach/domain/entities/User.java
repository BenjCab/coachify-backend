package com.switchfully.youcoach.domain.entities;

import com.switchfully.youcoach.infrastructure.util.ValidationUtil;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    public User setFirstName(String firstName) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(firstName, "Firstname");
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(lastName, "Lastname");
        this.lastName = lastName;
        return this;
    }

    public User setEmail(String email) {
        ValidationUtil.throwExceptionIfEmailNullEmptyBlankOrInvalid(email);
        this.email = email;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
