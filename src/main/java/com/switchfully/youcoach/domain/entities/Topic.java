package com.switchfully.youcoach.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Topic setId(Long id) {
        this.id = id;
        return this;
    }

    public Topic setName(String name) {
        this.name = name;
        return this;
    }
}
