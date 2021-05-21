package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.validations.ValidationUtil;

import javax.persistence.*;

@Entity
@Table(name = "coach_profile")
public class CoachProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "introduction")
    private String introduction;
    @Column(name = "availability")
    private String availability;
    @Column(name = "image")
    private String image;
    @OneToOne
    @JoinColumn(name="account_id")
    private AccountImpl account;

    public CoachProfile() {
    }

    private CoachProfile(Builder builder) {
        this.id = builder.id;
        this.introduction = builder.introduction;
        this.availability = builder.availability;
        this.image = builder.image;
        this.account = builder.account;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public CoachProfile setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public CoachProfile setIntroduction(String introduction) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(introduction,"Introduction");
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public CoachProfile setAvailability(String availability) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(availability,"Availability");
        this.availability = availability;
        return this;
    }

    public String getImage() {
        return image;
    }

    public CoachProfile setImage(String image) {
        this.image = image;
        return this;
    }

    public AccountImpl getAccount() {
        return account;
    }

    public CoachProfile setAccount(AccountImpl account) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(account,"Account");
        this.account = account;
        return this;
    }

    public static class Builder {
        private Long id;
        private String introduction;
        private String availability;
        private String image;
        private AccountImpl account;

        private Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setIntroduction(String introduction) {
            this.introduction = introduction;
            return this;
        }

        public Builder setAvailability(String availability) {
            this.availability = availability;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setAccount(AccountImpl account) {
            this.account = account;
            return this;
        }

        public CoachProfile build() {
            return new CoachProfile(this);
        }
    }
}
