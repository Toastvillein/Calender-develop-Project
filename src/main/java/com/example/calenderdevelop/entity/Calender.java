package com.example.calenderdevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="calender")
public class Calender extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "longtext")
    private String contents;

    public Calender() {
    }

    public Calender(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
