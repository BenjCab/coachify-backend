package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.api.Account;
import com.switchfully.youcoach.infrastructure.validations.ValidationUtil;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class AccountImpl implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "authority", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Authority> authorities;

    @Column(name = "image")
    private String image;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name= "reset_password_token")
    private String resetPasswordToken;

    public AccountImpl() {
    }

    private AccountImpl(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.authorities = builder.authorities;
        this.enabled = builder.enabled;
        this.resetPasswordToken = builder.resetPasswordToken;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    @Override
    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String encode) {
        this.password = encode;
    }

    @Override
    public List<Authority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountEnabled() {
        return this.enabled;
    }

    @Override
    public void enableAccount() {
        this.enabled = true;
    }

    public AccountImpl setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountImpl setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountImpl setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "AccountImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", enabled=" + enabled +
                '}';
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private List<Authority> authorities;
        private boolean enabled;
        private String resetPasswordToken;

        private Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setResetPasswordToken(String resetPasswordToken) {
            this.resetPasswordToken = resetPasswordToken;
            return this;
        }

        public Builder setFirstName(String firstName) {
            ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(firstName,"Firstname");
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(lastName,"Lastname");
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAuthorities(List<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public AccountImpl build() {
            return new AccountImpl(this);
        }
    }
}
