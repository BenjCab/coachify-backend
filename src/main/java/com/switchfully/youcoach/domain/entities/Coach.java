package com.switchfully.youcoach.domain.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="Coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long id;
    @OneToOne
    @JoinColumn(name="coachee_id")
    private Coachee coachee;
    @Column(name = "introduction")
    private String introduction;
    @Column(name = "availability")
    private String availability;
    @Column(name = "image")
    private String image;

    public Coach(Coachee coachee, String introduction, String availability, String image) {
        this.coachee = coachee;
        this.introduction = introduction;
        this.availability = availability;
        this.image = image;
    }

    public Coach() {
    }

    public Long getId() {
        return id;
    }

    public Coach setId(Long id) {
        this.id = id;
        return this;
    }

    public Coachee getCoachee() {
        return coachee;
    }

    public Coach setCoachee(Coachee coachee) {
        this.coachee = coachee;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Coach setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public Coach setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Coach setImage(String image) {
        this.image = image;
        return this;
    }
}
