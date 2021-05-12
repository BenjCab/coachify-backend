package com.switchfully.youcoach.domain.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="Coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private int id;
    @OneToOne
    @JoinColumn(name="coachee_id")
    private Coachee coachee;
    @Column(name = "introduction")
    private String introduction;
    @Column(name = "availability")
    private String availability;
    @Column(name = "image")
    private String image;

//    private List<Topic> topics;

    public Coach(Coachee coachee, String introduction, String availability, String image) {
        this.coachee = coachee;
        this.introduction = introduction;
        this.availability = availability;
        this.image = image;
    }

    public Coach() {
    }
}
